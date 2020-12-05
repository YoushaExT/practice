# Question: Write a program that computes the net amount of a bank account based on a transaction log from console input.
# The transaction log format is shown as following: D 100 W 200
#
# D means deposit while W means withdrawal. Suppose the following input is supplied to the program: D 300 D 300 W 200 D 100
# Then, the output should be: 500

s = input()

print(s)
a=s.split(" ")
b="".join(a)
D=""
W=""
i_D=0
i_W=0

for i in b:
    if i.isnumeric():
        if addMode=='D':
            D+=i
        elif addMode=='W':
            W+=i
    else:
        if D:
            i_D += int(D)
            D=""
        if W:
            i_W += int(W)
            W=""

        addMode=i
if D:
    i_D += int(D)
if W:
    i_W += int(W)

net = i_D-i_W

print(net)
