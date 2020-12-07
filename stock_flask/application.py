import os

from cs50 import SQL
from flask import Flask, flash, jsonify, redirect, render_template, request, session
from flask_session import Session
from tempfile import mkdtemp
from werkzeug.exceptions import default_exceptions, HTTPException, InternalServerError
from werkzeug.security import check_password_hash, generate_password_hash

from helpers import apology, login_required, lookup, usd
#added for time-
from datetime import datetime



# Configure application
app = Flask(__name__)

# Ensure templates are auto-reloaded
app.config["TEMPLATES_AUTO_RELOAD"] = True

# Ensure responses aren't cached
@app.after_request
def after_request(response):
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response

# Custom filter
app.jinja_env.filters["usd"] = usd

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_FILE_DIR"] = mkdtemp()
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Configure CS50 Library to use SQLite database
db = SQL("sqlite:///finance.db")

# Make sure API key is set
if not os.environ.get("API_KEY"):
    raise RuntimeError("API_KEY not set")


@app.route("/")
@login_required
def index():
    """Show portfolio of stocks"""
    userid = session.get("user_id")

    s_name = db.execute("SELECT DISTINCT name FROM transactions WHERE uid=?", userid)


    s_symbol = db.execute("SELECT DISTINCT symbol FROM transactions WHERE uid=?", userid)

    sym=s_symbol

    if s_symbol:
        s_symbol = s_symbol[0]

        s_symbol = s_symbol["symbol"]
    # s_symbol = type(s_symbol)

    lshares = []
    for i in sym:                                    #list to dict
        sb = i["symbol"]                             #dict to str
        var1 = db.execute("SELECT SUM(quantity) FROM transactions WHERE uid=? AND symbol=?", userid, sb) #var1 is dict
        var1 = var1[0]
        var1 = var1['SUM(quantity)']
        var2 = {}
        var2[sb] = var1
        lshares.append(var2) # create my own dict with 'symbol' and 'quantity' key-value pairs

    # shares = db.execute("SELECT SUM(quantity) FROM transactions WHERE uid=? AND symbol=?", userid, s_symbol)
    # shares = shares[0]
    # shares = shares['SUM(quantity)'] #old code for only 1 var

    lprice = []
    for i in sym:
        sb = i["symbol"]
        dic = lookup(sb)
        price = dic['price']
        var3 = {}
        var3[sb] = round(price,2)
        lprice.append(var3)


    # dic = lookup(s_symbol)
    # price = dic['price'] #Old code

    # tval = shares*price #old code

    # ltval = lshares[0]
    # ltval = ltval[sym[0]["symbol"]]
    ltval = []
    slt = 0

    for i in range(len(sym)):
        sb = sym[i]             #list to dict
        sb = sb["symbol"]       #dict to

        ls = lshares[i]         #{'AAPL': 7} from [{'AAPL': 7}, {'NFLX': 4}]
        ls = ls[sb]        #7 from {'AAPL': 7}

        lp = lprice[i]          #{'AAPL': 457.09} from [{'AAPL': 457.09}, {'NFLX': 481.53}]
        lp = lp[sb]         #457.09 from {'AAPL': 457.09}

        var4 = {}
        slt += ls*lp
        var4[sb] = round(ls*lp,2)            #7 x 457.09
        ltval.append(var4)


    cash = db.execute("SELECT cash FROM users WHERE id=?", userid)
    # c = cash
    cash = cash[0]
    cash = cash["cash"]

    slt = slt + cash

    total = slt
    cash = round(cash,2)
    total = round(total,2)

    ls=lshares



    # this prevents from displaying 0 quantity stocks

    count = 0
    sym2 = list.copy(sym)

    for i in sym:
        sb = i["symbol"]
        var2 = db.execute("SELECT SUM(quantity) FROM transactions WHERE uid=? AND symbol=?", userid, sb) #var1 is dict
        var2 = var2[0]
        var2 = var2['SUM(quantity)']
        if var2==0:
            # sym.remove(sym[count])
            sym2.remove(sym2[count])
            lshares.remove(lshares[count])
            s_name.remove(s_name[count])
            lprice.remove(lprice[count])
            ltval.remove(ltval[count])

            count -= 1
        count+=1

    # end of 0 quantity code
    length = len(s_name)


    return render_template("index.html", s_name=s_name, c=cash, total=total, length=length, sym=sym2, l=lshares, lp=lprice, lt=ltval, slt=slt)

    # cash = db.execute("select username from users where id=:uid", uid=userid)




@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():
    """Buy shares of stock"""
    if request.method == "POST":

        dic = lookup(request.form.get("symbol"))

        if int(request.form.get("shares")) <= 0:
            return apology("Please select a positive integer")
        if dic == None:
            return apology("The symbol does not exist")

        # 8/14 code here
        #id , userid , symbol , price, quantity , time
        #id autoset hojaegi _
        #userid session.get("user_id")
        userid = session.get("user_id")
        symbol = dic["symbol"]

        price = dic["price"]
        quantity = int(request.form.get("shares"))

        render_template("quoted.html", name = dic["name"], price = dic["price"], symbol = dic["symbol"])


        quantity = int(request.form.get("shares"))

        now = datetime.now()
        dt_string = now.strftime("%d/%m/%Y %H:%M:%S")

        time = dt_string

        username = db.execute("select username from users where id=:uid", uid=userid)
        name = dic["name"]

        cash = db.execute("select cash from users where id=:uid", uid=userid)

        #izafi kam
        username = username[0]["username"]

        cash = cash[0]
        cash = cash["cash"]

        q = cash - (price * quantity)
        if q < 0:
            return apology("You can't afford", 403)
        cash = q

        # return render_template("buy2.html", userid=userid, symbol=symbol, price=price, quantity=quantity, time=time, username=username, name=name , cash = cash)

        # db.execute("INSERT INTO purchases (userid, symbol, price, quantity, time, username, name) VALUES (':uid', ':symbol', ':price', ':quantity', ':time', ':username', ':name')"
        # , uid=userid, symbol=symbol, price=price, quantity=quantity, time=time, username=username, name=name)
        # db.execute("INSERT INTO test (var,var2,var3) VALUES (?,?,?)", username, name, time)

        db.execute("UPDATE users SET cash = :cash WHERE id = :uid;", uid=userid, cash=cash)
        db.execute("INSERT INTO transactions (uid,symbol,price,quantity,time,username,name) VALUES (?,?,?,?,?,?,?)", userid,symbol,price,quantity,time,username,name)

        # end code here
        return redirect("/")
    else:
        return render_template("buy.html")
    # return apology("TODO buy")


@app.route("/history")
@login_required
def history():
    """Show history of transactions"""

    userid = session.get("user_id")

    tid = db.execute("SELECT id FROM transactions WHERE uid=?", userid)


    mydict = {}
    for di in tid:
        ls=[]
        t=di["id"]      #t is the id

        sb = db.execute("SELECT symbol FROM transactions WHERE id=?", t)
        pr = db.execute("SELECT price FROM transactions WHERE id=?", t)
        ti = db.execute("SELECT time FROM transactions WHERE id=?", t)
        q = db.execute("SELECT quantity FROM transactions WHERE id=?", t)

        sb=sb[0]["symbol"]
        pr=pr[0]["price"]
        ti=ti[0]["time"]
        q=q[0]["quantity"]

        ls.append(sb)
        ls.append(q)
        ls.append(pr)
        ls.append(ti)

        mydict[t]=ls


    # return apology("TODO")
    return render_template("history.html", d=mydict)


@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in"""

    # Forget any user_id
    session.clear()

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # Ensure username was submitted
        if not request.form.get("username"):
            return apology("must provide username", 403)

        # Ensure password was submitted
        elif not request.form.get("password"):
            return apology("must provide password", 403)

        # Query database for username
        rows = db.execute("SELECT * FROM users WHERE username = :username",
                          username=request.form.get("username"))

        # Ensure username exists and password is correct
        if len(rows) != 1 or not check_password_hash(rows[0]["hash"], request.form.get("password")):
            return apology("invalid username and/or password", 403)

        # Remember which user has logged in
        session["user_id"] = rows[0]["id"]


        # Redirect user to home page
        return redirect("/")

    # User reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")


@app.route("/logout")
def logout():
    """Log user out"""

    # Forget any user_id
    session.clear()

    # Redirect user to login form
    return redirect("/")


@app.route("/quote", methods=["GET", "POST"])
@login_required
def quote():
    """Get stock quote."""
    if request.method == "POST":
        # todo
        # return apology("Quote todo")
        dic = lookup(request.form.get("symbol"))
        if dic == None:
            return apology("The symbol does not exist")
        return render_template("quoted.html", name = dic["name"], price = dic["price"], symbol = dic["symbol"])
    else:
        return render_template("quote.html")


@app.route("/register", methods=["GET", "POST"])
def register():
    """Register user"""
    if request.method == "POST":

        user = db.execute("SELECT * FROM users WHERE username = :username",
                  username=request.form.get("username"))

        if not request.form.get("username"):
            return apology("Must provide a username", 403)
        elif len(user) == 1:
            return apology("Username already exists!", 403)

        elif not request.form.get("password"):
            return apology("Must provide a password", 403)
        elif not request.form.get("password") == request.form.get("confirmation"):
            return apology("The passwords must match!", 403)

        db.execute("INSERT INTO users (username, hash) VALUES (:username, :h)", username=request.form.get("username"), h=generate_password_hash(request.form.get("password")))
        return redirect("/login")
        #todo

    # if request.method == "POST":

    #     # Ensure username was submitted
    #     if not request.form.get("username"):
    #         return apology("must provide username", 403)

    #     # Ensure password was submitted
    #     elif not request.form.get("password"):
    #         return apology("must provide password", 403)

    else:
        return render_template("register.html")
    return apology("TEST1")


@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    """Sell shares of stock"""
    if request.method == "POST":
        # database ko edit karna hai buy aur sell add to db file
        if not request.form.get("symbol"): #if no symbol is selected
            return apology("MISSING SYMBOL", 400)

        if request.form.get("shares"):
            if int(request.form.get("shares")) <= 0:   #cant convert if it doesnt exist-
                return apology("Shares must be positive", 400)

        #this cant happen as symbol can only be selected from a dropdown-
        # if dic == None:
        #     return apology("The symbol does not exist")


        dic = lookup(request.form.get("symbol"))

        userid = session.get("user_id")
        symbol = dic["symbol"]


        var1 = db.execute("SELECT SUM(quantity) FROM transactions WHERE uid=? AND symbol=?", userid, symbol) #var1 is dict
        var1 = var1[0]
        var1 = var1['SUM(quantity)']

        if int(request.form.get("shares")) > var1:
            return apology("TOO MANY SHARES", 400)

        price = dic["price"]
        quantity = int(request.form.get("shares"))

        cash = db.execute("SELECT cash FROM users WHERE id=?",userid)
        cash = cash[0]
        cash = cash["cash"]

        cash += quantity*price

        quantity = -quantity

        # updates the cash
        db.execute("UPDATE users SET cash = :cash WHERE id = :userid;", userid=userid, cash=cash)

        #time username name
        #time
        now = datetime.now()
        dt_string = now.strftime("%d/%m/%Y %H:%M:%S")

        time = dt_string

        #username
        username = db.execute("select username from users where id=:uid", uid=userid)

        cash = db.execute("select cash from users where id=:uid", uid=userid)

        username = username[0]["username"]

        #name
        name = dic["name"]

        db.execute("INSERT INTO transactions (uid,symbol,price,quantity,time,username,name) VALUES (?,?,?,?,?,?,?)", userid,symbol,price,quantity,time,username,name)


        return redirect("/")
    else:
        # isko info chahiye purchased stocks symbols ka

        userid = session.get("user_id")
        # s_name = db.execute("SELECT DISTINCT name FROM transactions WHERE uid=?", userid)
        sym = db.execute("SELECT DISTINCT symbol FROM transactions WHERE uid=?", userid)


        # this prevents from displaying 0 quantity stocks

        count = 0
        sym2 = list.copy(sym)

        for i in sym:
            sb = i["symbol"]
            var2 = db.execute("SELECT SUM(quantity) FROM transactions WHERE uid=? AND symbol=?", userid, sb) #var1 is dict
            var2 = var2[0]
            var2 = var2['SUM(quantity)']
            if var2==0:
                # sym.remove(sym[count])
                sym2.remove(sym2[count])
                count -= 1
            count+=1

        # end of 0 quantity code

        return render_template("sell.html",sym=sym2)


@app.route("/add", methods=["GET", "POST"])
@login_required
def add():

    if request.method == "POST":

        if request.form.get("amount"):
            if int(request.form.get("amount")) <= 0:
                return apology("Amount must be positive",400)


        userid = session.get("user_id")

        cash = db.execute("SELECT cash FROM users WHERE id=?",userid)

        cash = cash[0]["cash"]


        amount = int(request.form.get("amount"))

        cash += amount

        db.execute("UPDATE users SET cash=? WHERE id=?;",cash,userid)

        # return apology("TODO add")
        return redirect("/")
    else:

        userid = session.get("user_id")

        cash = db.execute("SELECT cash FROM users WHERE id=?",userid)

        cash = cash[0]["cash"]

        return render_template("add.html",cash=cash)



def errorhandler(e):
    """Handle error"""
    if not isinstance(e, HTTPException):
        e = InternalServerError()
    return apology(e.name, e.code)


# Listen for errors
for code in default_exceptions:
    app.errorhandler(code)(errorhandler)



