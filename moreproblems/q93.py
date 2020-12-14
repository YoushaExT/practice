# With two given lists [1,3,6,78,35,55] and [12,24,35,24,88,120,155],
#  write a program to make a list whose elements are intersection of the above given lists.
#
# Hints: Use set() and "&=" to do set intersection operation.

L1=[1,3,6,78,35,55]
L2=[12,24,35,24,88,120,155]

L1=set(L1)
L2=set(L2)

# I = list(L1.intersection(L2))
# I = L1 & L2
# print(I)

L1 &= L2
print(L1)
