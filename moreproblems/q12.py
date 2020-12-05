# Question: Write a program, which will find all such numbers between 1000 and 3000 (both included)
# such that each digit of the number is an even number. The numbers obtained should be printed in a comma-separated sequence on a single line.
L=[]

for i in range(1000,3001):
    i=str(i)
    # iterate through all 4 digits; len(i)=4
    for j in range(len(i)):
        # if not even dont check further
        if int(i[j])%2!=0:
            break
        # if even and last iteration
        if j==len(i)-1:
            L.append(i)

    # alternatively
    # if (int(i[0])%2==0) and (int(i[1])%2==0) and (int(i[2])%2==0) and (int(i[3])%2==0):
    #     L.append(i)

print(','.join(L))
