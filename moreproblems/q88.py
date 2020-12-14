# By using list comprehension, please write a program to print the list after removing delete numbers
# which are divisible by 5 and 7 in [12,24,35,70,88,120,155].

L = [12,24,35,70,88,120,155]

L = [x for x in L if x%5!=0 and x%7!=0]

print(L)
