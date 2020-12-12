# Define a function which can generate and print a list where the values are square of numbers between 1 and 20 (both included).

def myFunc():
    L=[]
    for i in range(1,21):
        L.append(i**2)
    print(L)

myFunc()
