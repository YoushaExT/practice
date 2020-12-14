# Please write a program which prints all permutations of [1,2,3]
#
# Hints: Use itertools.permutations() to get permutations of list.

import itertools

L=[1,2,3]

i=list(itertools.permutations(L,3))

print(i)
