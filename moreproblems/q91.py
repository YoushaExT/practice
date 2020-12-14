# By using list comprehension, please write a program to print the list after removing the 0th,4th,5th numbers in [12,24,35,70,88,120,155].
#
# Hints: Use list comprehension to delete a bunch of element from a list. Use enumerate() to get (index, value) tuple.

L=[12,24,35,70,88,120,155]

# L = [x for i,x in enumerate(L) if i!=0 and i!=4 and i!=5]
L = [x for (i,x) in enumerate(L) if i not in (0,4,5)]

print(L)
