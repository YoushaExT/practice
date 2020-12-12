# Write a program which can map() and filter() to make a list whose elements are square of even number in [1,2,3,4,5,6,7,8,9,10].

L = [1,2,3,4,5,6,7,8,9,10]

filterL = filter(lambda x:x%2==0,L)

mapL = list(map(lambda x:x**2,filterL))

print(L,mapL)

# note: after passing through map object filter list becomes empty list(filterL) returns []
