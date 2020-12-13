# The Fibonacci Sequence is computed based on the following formula:
#
# f(n)=0 if n=0 f(n)=1 if n=1 f(n)=f(n-1)+f(n-2) if n>1
#
# Please write a program using list comprehension to print the Fibonacci Sequence in comma separated form with a given n input by console.
#
# Example: If the following n is given as input to the program:
#
# 7
#
# Then, the output of the program should be:
#
# 0,1,1,2,3,5,8,13

def myFunc(n):
    if n==0:
        return 0
    elif n==1:
        return 1
    elif n>1:
        return myFunc(n-1)+myFunc(n-2)

n = int(input())

L = [str(myFunc(x)) for x in range(n+1)]
print(','.join(L))

# L=[]
# for i in range(n+1):
#     if i==0:
#         L.append(0)
#     elif i==1:
#         L.append(1)
#     else:
#         L.append(L[i-1]+L[i-2])
