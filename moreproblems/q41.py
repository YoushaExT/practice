# Define a function which can generate and print a tuple where the value are square of numbers between 1 and 20 (both included).

def myFunc():
    L=[]
    for i in range(1,21):
        L.append(i**2)
    L=tuple(L)
    print(L) #[startIncluded:stop:step]

myFunc()
