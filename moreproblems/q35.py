# Define a function which can generate a dictionary where the keys are numbers between 1 and 20 (both included)
# and the values are square of keys. The function should just print the values only.

def myFunc():
    d={}
    # d=dict() <-- or use this
    for i in range(1,21):
        d[i]=i**2

    # method 1
    # print(list(d.values()))

    # method 2
    # for (k,v) in d.items():
    #     print(k)

myFunc()
