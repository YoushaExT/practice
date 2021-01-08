import time
# import random
from selection import Selection
from insertion import Insertion
from shell import Shell
from merge import Merge
from mergeBU import MergeBU
from quick import Quick
from quick3 import Quick3
from sorted import isSorted
from sorted import knuth_shuffle as shuffle

n = 4000

numbers = [x for x in range(n)]
assert(isSorted(numbers))
numbers = shuffle(numbers)
assert(not isSorted(numbers))  # highly unlikely for large arrays

# d = 2000  # uncomment to see results in case of several duplicates, begin
# parts = 10
# # creates an array with values 0,100,200 -- 900 , 100 duplicates each
# duplicates = [parts*x for x in range(d//parts) for _ in range(d//parts)]
# duplicates = shuffle(duplicates)
# numbers = duplicates
# n = d  # uncomment, end

# numList = []
timeList = []

myOperations = [Selection.sort, Insertion.sort, Shell.sort, Merge.sort, MergeBU.sort, Quick.sort, Quick3.sort, sorted]
# myOperations = [Shell.sort, Merge.sort, MergeBU.sort, Quick.sort, Quick3.sort, sorted] #uncomment to perform only fast sorts

print(f"Time taken in sorting an array of size {n}:")
for operation in myOperations:
    numbersCopy = numbers.copy()
    start = time.time()
    operation(numbersCopy)
    # assert(isSorted(numbersCopy))
    elapsed = time.time() - start
    timeList.append(elapsed)

    # print numbers nicely in a line
    spaces = (12 - len(operation.__module__)) * " "
    nicePrint = operation.__module__ + " sort:" + spaces
    # print(f"{operation.__module__} sort: {elapsed}")
    print(f"{nicePrint}{elapsed}")

count = 0

# prevent division by 0
if timeList[0] > 0:
    print(f"Time taken with respect to {myOperations[0].__module__} sort: ")
    for operation in myOperations:
        # print numbers nicely in a line
        spaces = (12 - len(operation.__module__)) * " "
        nicePrint = operation.__module__ + " sort:" + spaces
        print(f"{nicePrint}{round(100*timeList[count]/timeList[0], 2)}%")
        count += 1
