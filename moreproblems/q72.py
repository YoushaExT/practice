# Please write a binary search function which searches an item in a sorted list.
# The function should return the index of element to be searched in the list.
#
# Hints: Use if/elif to deal with conditions.
import math

def bin_search(L,e):
    index = -1
    bottom = 0
    top = len(L)-1 #-1 bcz 0 indexed
    while index==-1 and top>=bottom:
    # for i in range(math.ceil(math.log(len(L),2))):
        mid = int((bottom+top)/2)
        if L[mid]==e:
            index=mid
        elif L[mid]>e:
            top=mid-1
        else:
            bottom=mid+1
    return index

L=[1,3,5,7,9,11,13,15,17,19,21,23,25]

s=int(input())

result = bin_search(L,s)
if result==-1:
    print("not found")
else:
    print("index is",result)
