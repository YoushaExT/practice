# Question: Write a program which can compute the factorial of a given numbers.
# The results should be printed in a comma-separated sequence on a single line.
# Suppose the following input is supplied to the program: 8 Then, the output should be: 40320

n = int(input("Number: "))
f = 1

for i in range(n,0,-1):
    if i==0:
        f*=1
    else:
        f*=i

print(f)


# alternatively
def fct(x):
    if x == 0:
        return 1
    return x * fct(x - 1)

x=n
print(fct(x))
