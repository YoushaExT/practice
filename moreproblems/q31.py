# Define a function that can accept two strings as input and print the string with maximum length in console.
# If two strings have the same length, then the function should print al l strings line by line.

def maxStr(s1,s2):
    if len(s1)>len(s2):
        print(s1)
    elif len(s1)==len(s2):
        print(s1)
        print(s2)
    else:
        print(s2)

s1 = input()
s2 = input()

maxStr(s1,s2)
