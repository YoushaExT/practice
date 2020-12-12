# Assuming that we have some email addresses in the "username@companyname.com" format,
# please write program to print the user name of a given email address. Both user names and company names are composed of letters only.
#
# Example: If the following email address is given as input to the program:
#
# john@google.com
#
# Then, the output of the program should be:
#
# john
#
# In case of input data being supplied to the question, it should be assumed to be a console input.

# e=input()
#
# n=''
# for c in e:
#     if c=='@':
#         break
#     n+=c
#
# print(n)

# method 2
import re
emailAddress = input()
# () used to group, first group contains 1 or more word characters(a-Z,0-9 or _); followed by @ followed by 2nd group which
# covers the whole email part; followed by 3rd group of 1+ word chars and the . character; followed by 4th group of com
pat2 = "(\w+)@((\w+\.)+(com))"
# pat2 = "(\w+)@.*"
r2 = re.match(pat2,emailAddress)
# print(r2,type(r2))
print(r2.group(1))
# print(r2.group(0),r2.group(1),r2.group(2),r2.group(3),r2.group(4))
