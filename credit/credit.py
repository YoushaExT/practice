# this program will identify the type and validity of a credit card number
def main():
    a=get_int("Enter a credit card number: ")

    print(a)

    if check_luhn(a):
        print("passed luhn check")
    else:
        print("did NOT pass luhn check")
    # 10^10 is 10**10 or pow(10,10)
    # b=10**10
    # print(b)

def check_luhn(num):
    # Multiply every other digit by 2, starting with the number’s second-to-last digit, and then add those products’ digits together.
    # 1234567%100 ->> 67 /10 ->> 6 * 2 => 12
    # 1234567/100 -> 12345 % 100 ->> 45 /10 ->> 4 * 2 =>8 eventually the num becomes 0
    other = 0
    num1=num

    while num1>0:
        prod = 2*int((num1%100)/10)
        # e.g. digits of 12 are 1 and 2, 12%10=2, 12/10=1; need to add digits not products
        other += prod%10
        other += int(prod/10)
        num1 = int(num1/100)
    print(other)

    # Add the sum to the sum of the digits that weren’t multiplied by 2.
    not_other=0
    num2=num
    # 1234567%10 ->> 7 , 1234567/100 -> 12345%10 ->5 .. 3 .. 1
    while num2>0:
        not_other += num2%10
        num2 = int(num2/100)

    print(not_other)
    sum = other+not_other
    print(sum)
    # If the total’s last digit is 0 (or, put more formally, if the total modulo 10 is congruent to 0), the number is valid!
    if sum%10==0:
        return True
    else:
        return False

def get_int(s):
    while True:
        try:
            test = int(input(s))
            # if user entered a number, return will break the while loop
            return test
        except:
            # instead of displaying error just reprompt for input
            continue

main()
