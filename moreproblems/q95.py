# Define a class Person and its two child classes: Male and Female.
# All classes have a method "getGender" which can print "Male" for Male class and "Female" for Female class.
#
# Hints: Use Subclass(Parentclass) to define a child class.

class Person:
    def getGender(self):
        print("Not specified")

class Male(Person):
    def getGender(self):
        print("male")

class Female(Person):
    def getGender(self):
        print("female")

person1 = Male()
person2 = Female()
person3 = Person()

person1.getGender()
person2.getGender()
person3.getGender()
