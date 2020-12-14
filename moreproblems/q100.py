# Write a program to solve a classic ancient Chinese puzzle:
# We count 35 heads and 94 legs among the chickens and rabbits in a farm.
#  How many rabbits and how many chickens do we have?
#
# Hint: Use for loop to iterate all possible solutions.
#
# simultaneous eqns become:
# c+r=35
# 4r+2c=94

def main():
    heads = 35
    legs=94
    for i in range(heads+1):
        c=i
        r=heads-i
        if (4*r+2*c)==legs:
            print(r,c)
            return

    print("No Solutions")

main()
