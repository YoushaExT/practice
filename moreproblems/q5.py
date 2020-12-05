# Question: Define a class which has at least two methods: getString: to get a string from console input printString:
#  to print the string in upper case. Also please include simple test function to test the class methods.

class myClass:
    # def __init__(self):
    #     self.str=""
    def getString(self, s):
        self.str=input(s)
    def printString(self):
        print(self.str.upper())

def test():
    c = myClass()
    c.getString("Type a string: ")
    c.printString()

test()
