def main():
    # input an integer from 1-8
    n = get_pos_int()
    # draw triangle
    for i in range(n):
        # for j in range(n-i, 1, -1):
        for j in range(n-i-1):
            print(" ", end="")
        for j in range(i+1):
            print("#", end="")
        print()


def get_pos_int():
    while True:
        m = int(input("Enter height between 1 and 8:\n"))
        if m > 0 and m <= 8:
            break
    return m


main()
