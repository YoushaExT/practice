# Define a class named American and its subclass NewYorker.

class American(object):
    @staticmethod
    def printNationality():
        print("American")
    # pass
    classVar = 'aClassVar'
    def __init__(self):
        self.instanceVar='anInstanceVar'

class NewYorker(American):
    pass

anAmerican = American()
aNewYorker = NewYorker()
print(anAmerican)
print(aNewYorker)

anAmerican.printNationality()
American.printNationality()
aNewYorker.printNationality()
NewYorker.printNationality()

print(American.classVar,anAmerican.classVar,anAmerican.instanceVar)
print(NewYorker.classVar,aNewYorker.classVar,aNewYorker.instanceVar)
