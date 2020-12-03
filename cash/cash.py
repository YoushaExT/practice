# this program will calculate the min no. of coins req. to give change
def main():
    t=get_pos_float("Enter a float: ")

    print(t)
    print(type(t))


# ensures a positive float input
def get_pos_float(s):
    while True:
        flt=get_float(s)
        if flt>=0:
            return flt            
        print("Not a positive float")

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
