# Question: Write a program that accepts a sequence of whitespace separated words as input and prints the words
# after removing all duplicate words and sorting them alphanumerically.
# Suppose the following input is supplied to the program:
#  hello world and practice makes perfect and hello world again Then, the output should be: again and hello makes perfect practice world

# convert string to list
s = input().split(' ')

# convert list to set to remove duplicates
set1 = set(s)

# convert back to list
l = list(set1)

# sort the list
l.sort()

# convert list to string
s2 = ' '.join(l)

print(s2)
