# this program will calculate the min no. of coins req. to give change
def main():
    cash=get_pos_float("Enter a float: ")

    cash *= 100
    # convert to int to get the floor value, round down
    quarters = int(cash / 25)
    quarters_rem = cash % 25
    dimes = int(quarters_rem / 10)
    dimes_rem = quarters_rem % 10
    nickels = int(dimes_rem / 5)
    pennies = int(dimes_rem % 5)

    total = quarters+dimes+nickels+pennies

    print(total)


# ensures a positive float input
def get_pos_float(s):
    while True:
        flt=get_float(s)
        if flt>=0:
            return flt
        print("Not a positive float")

def get_float(s):
    while True:
        try:
            test = float(input(s))
            # if user entered a number, return will break the while loop
            return test
        except:
            # error handling for non-number input
            print("Not a valid float.")

main()
