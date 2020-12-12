# Write a program which can filter even numbers in a list by using filter function. The list is: [1,2,3,4,5,6,7,8,9,10].

L=[1,2,3,4,5,6,7,8,9,10]

# def myFunc(x):
#     if x%2==0:
#         return True
#     else:
#         return False
# even = list(filter(myFunc,L))

# even = list(filter(lambda x:True if x%2==0 else False,L)) <-- bad syntax
even = list(filter(lambda x: x%2==0, L))

print(even)
# print(filter.__doc__)
