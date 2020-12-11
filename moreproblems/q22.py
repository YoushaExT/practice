# Question: Write a program to compute the frequency of the words from the input.
# The output should output after sorting the key alphanumerically.
# Suppose the following input is supplied to the program:
# New to Python or choosing between Python 2 and Python 3? Read Python 2 or Python 3.
# Then, the output should be: 2:2 3.:1 3?:1 New:1 Python:5 Read:1 and:1 between:1 choosing:1 or:2 to:1

input1 = input().split(' ')

myDict={}
for word in input1:
    myDict[word]=0

for word in input1:
    if word in input1:
        myDict[word]+=1

# convert dict to list of tuples
l = list(myDict.items())
# sort the list by the first parameter of the tuple i.e. keys
l.sort(key=lambda a:a[0])

# print formatting
s=''
for t in l:
    s+=f"{t[0]}:{t[1]} "

# no space character after the last digit; slice the last char of str
print(s[:-1])
