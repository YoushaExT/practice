# this program will calculate the min no. of coins req. to give change
def main():
    t=get_float("Enter a float: ")

    print(t)
    print(type(t))



def get_float(s):
    while True:
        try:
            test = float(input(s))
            # if user entered a number, return will break the while loop
            return test
        except:
            # error handling for non-number input
            print("Not a valid float.")

main()
