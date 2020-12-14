# Please write a program to generate a list with 5 random numbers between 100 and 200 inclusive.
#
# Hints: Use random.sample() to generate a list of random values.

import random

L = random.sample([x for x in range(100,201)],5)

print(L)
