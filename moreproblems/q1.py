# Question: Write a program which will find all such numbers which are divisible by 7 but are not a multiple of 5
# , between 2000 and 3200 (both included). The numbers obtained should be printed in a comma-separated sequence on a single line.

# all numbers from 2000-3200 iterated
l=[]
for i in range(2000,3201):
    # if i is divisible by 5 go to the next iteration/dont print
    if i%5==0:
        continue
    if i%7==0:
        l.append(str(i))

print(','.join(l))
