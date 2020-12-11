# Question A robot moves in a plane starting from the original point (0,0).
# The robot can move toward UP, DOWN, LEFT and RIGHT with a given steps.
# The trace of robot movement is shown as the following: UP 5 DOWN 3 LEFT 3 RIGHT 2 ¡­
# The numbers after the direction are steps.
# Please write a program to compute the distance from current position after a sequence of movement and original point.
# If the distance is a float, then just print the nearest integer.
# Example: If the following tuples are given as input to the program: UP 5 DOWN 3 LEFT 3 RIGHT 2
# Then, the output of the program should be: 2

# for square root
import math

pos=[0.0,0.0]

steps = input().split(' ')

c=0
for i in steps:
    if i=='UP':
        pos[1]+=float(steps[c+1])
    elif i=='DOWN':
        pos[1]-=float(steps[c+1])
    elif i=='RIGHT':
        pos[0]+=float(steps[c+1])
    elif i=='LEFT':
        pos[0]-=float(steps[c+1])
    c+=1

dist = round(math.sqrt(pos[0]**2+pos[1]**2))

print(dist)
