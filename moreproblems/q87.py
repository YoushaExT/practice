# Please write a program to print the list after removing delete even numbers in [5,6,77,45,22,12,24].
#
# Hints: Use list comprehension to delete a bunch of element from a list.

L = [5,6,77,22,12,24]

L = [x for x in L if x%2!=0]

print(L)
