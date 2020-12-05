# Question: Write a program which accepts a sequence of comma separated 4 digit binary numbers as its input and
#  then check whether they are divisible by 5 or not. The numbers that are divisible by 5 are to be printed in a comma separated sequence.
#  Example: 0100,0011,1010,1001 Then the output should be: 1010 Notes: Assume the data is input by console.

# create a function to create binary to decimal
def bin_to_dec(n):
    i=0
    d=0
    while True:
        if n==0:
            break
        else:
            d+=n%10*pow(2,i)
            n=int(n/10)
            i+=1
    return d

dnum = [x for x in input().split(',') if bin_to_dec(int(x))%5==0]

print(','.join(dnum))
