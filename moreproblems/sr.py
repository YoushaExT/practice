# lets create an iteration to calculate sq root

n = int(input("Enter a number: "))

def calcSqRoot(n):
    r=1
    for i in range(10000):
        if n/r-r>0.1:
            r*=3
        elif n/r-r<-0.1:
            r/=2
        else:
            print("break")
            break

    r = round(r,1)
    print(r,n)

calcSqRoot(n)

# correct to 0.1 and works upto approx n=1,000,000 need to improve
