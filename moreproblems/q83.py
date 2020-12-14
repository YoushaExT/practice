# Please write a program to print the running time of execution of "1+1" for 100 times.
#
# Hints: Use timeit() function to measure the running time.

import timeit

print(timeit.timeit(stmt = '1+1',number=100))
# print(timeit.repeat(stmt = '1+1',number=100,repeat=5))

# from timeit import Timer
# t = Timer("for i in range(100):1+1")
# print(t.timeit())

# ==ignore==
# # code snippet to be executed only once
# mysetup = "from math import sqrt"
#
# # code snippet whose execution time is to be measured
# mycode = '''
# def example():
#     mylist = []
#     for x in range(100):
#         mylist.append(sqrt(x))
# '''
#
# # timeit statement
# print (timeit.timeit(setup = mysetup,
#                      stmt = mycode,
#                      number = 10000))
