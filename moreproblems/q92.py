# By using list comprehension, please write a program to print the list after removing the value 24 in [12,24,35,24,88,120,155].
#
# Hints: Use list's remove method to delete a value.

L=[12,24,35,24,88,120,155]

L.remove(24)
# L = [x for x in L if x!=24]

print(L)
