# Define a class named Circle which can be constructed by a radius. The Circle class has a method which can compute the area.

class Circle:
    def __init__(self,radius):
        self.radius=radius
    def area(self):
        return 2*3.14159*self.radius


myCircle = Circle(10)

print(myCircle.area())
