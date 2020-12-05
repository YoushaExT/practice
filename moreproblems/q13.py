# Question: Write a program that accepts a sentence and calculate the number of letters and digits.
#  Suppose the following input is supplied to the program: hello world! 123 Then, the output should be: LETTERS 10 DIGITS 3

s = input()

letters=0
digits=0

for i in s:
    if i.isalpha():
        letters+=1
    elif i.isnumeric():
        digits+=1

print(f"LETTERS {letters} DIGITS {digits}")
