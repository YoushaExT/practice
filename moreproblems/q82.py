# Please write a program to compress and decompress the string "hello world!hello world!hello world!hello world!".
#
# Hints: Use zlib.compress() and zlib.decompress() to compress and decompress a string.

import zlib
s = 'hello world!hello world!hello world!hello world!'
print(s,type(s))
# s = b'hello world!hello world!hello world!hello world!'
# s = bytes(s,'utf-8')
# s = str.encode(s)
s = s.encode('utf-8')
print(s,type(s))

s1= zlib.compress(s)

print(s1)

s2= zlib.decompress(s1)

print(s2)

# ==ignore==
#utf-8 characters:
# a="\N{GREEK CAPITAL LETTER DELTA}"
# a='\u0394'
# a='haha\U00000394haha'
# b='dollar sign: \u0024'
# c='pi: \u03A0'
#
# print(a,b,c)
