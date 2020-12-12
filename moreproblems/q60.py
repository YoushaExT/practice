# Write a program which accepts a sequence of words separated by whitespace as input to print the words composed of digits only.
#
# Example: If the following words is given as input to the program:
#
# 22 cats and 33 dogs.
#
# Then, the output of the program should be:
#
# ['22', '33']

import re

s = input()

print(re.findall('\d+',s))
