# Define a function which can generate a list where the values are square of numbers between 1 and 20 (both included).
# Then the function needs to print the last 5 elements in the list.

def myFunc():
    L=[]
    for i in range(1,21):
        L.append(i**2)
    print(L[-5:]) #[startIncluded:stop:step]

myFunc()
