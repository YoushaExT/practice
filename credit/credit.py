def main():
    a=get_int("Enter an integer: ")

    print(a)


def get_int(s):
    while True:
        try:
            test = int(input(s))
            # if user entered a number, return will break the while loop
            return test
        except:
            continue

main()
