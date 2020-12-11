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

a=sorted(myDict.keys())

myDict2={}

for k in a:
    myDict2[k]=myDict[k]
print(myDict2)

# print formatting
for i in myDict2:
    print(f"{i}:{myDict2[i]} ",end="")
