# Write a program to generate and print another tuple whose values are even numbers in the given tuple (1,2,3,4,5,6,7,8,9,10).

t = (1,2,3,4,5,6,7,8,9,10)

t2=[]
for x in t:
    if x%2==0:
        t2.append(x)

t2=tuple(t2)
print(t2)
