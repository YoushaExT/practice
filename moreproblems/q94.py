# With a given list [12,24,35,24,88,120,155,88,120,155], write a program to print this list
# after removing all duplicate values with original order reserved.
#
# Hints: Use set() to store a number of values without duplicate.

L = [12,24,35,24,88,120,155,88,120,155]

L3=[]
for x in L:
    if x not in L3:
        L3.append(x)

print(L3)

# idk what the point of set is in this problem?
