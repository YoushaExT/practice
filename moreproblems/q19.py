# Question: You are required to write a program to sort the (name, age, height) tuples by ascending order
# where name is string, age and height are numbers. The tuples are input by console.
# The sort criteria is: 1: Sort based on name; 2: Then sort based on age; 3: Then sort by score.
# The priority is that name > age > score. If the following tuples are given as input to the program:
# Tom,19,80 John,20,90 Jony,17,91 Jony,17,93 Json,21,85
# Then, the output of the program should be:
# [('John', '20', '90'), ('Jony', '17', '91'), ('Jony', '17', '93'), ('Json', '21', '85'), ('Tom', '19', '80')]

# Tom,19,80 John,20,90 Jony,17,95 Jony,17,93 Json,21,85 Tom,25,82 Tom,26,82 John,20,80 Yi,9,80 Yi,5,91 Yi,1,92  - test input no. 2

p = input().split(' ')
l2=[]

for i in p:
    l=i.split(',')
    t=tuple(l)
    l2.append(t)

l2.sort(key=lambda a:(a[0],a[1],a[2]))
print(l2)

# Method 2
# 1) sort by name
# l2.sort(key=lambda a:a[0])
#
# # since its bubble sort-ish need to repeat sort n*n times
# for y in range(len(l2)-1):
#     for x in range(len(l2)-1):
#         # if same name in consecutive elements
#         if l2[x][0]==l2[x+1][0]:
#             # 2) sort by age
#             if l2[x][1]>l2[x+1][1]:
#                 tmp=l2[x+1]
#                 l2[x+1]=l2[x]
#                 l2[x]=tmp
#             # if age also match
#             elif l2[x][1]==l2[x+1][1]:
#                 # 3) sort by score
#                 if l2[x][2]>l2[x+1][2]:
#                     tmp=l2[x+1]
#                     l2[x+1]=l2[x]
#                     l2[x]=tmp
#
# print(l2)

#Method 3
# from operator import itemgetter, attrgetter
#
# l = []
# while True:
#     s = input()
#     if not s:
#         break
#     l.append(tuple(s.split(",")))
#
# print sorted(l, key=itemgetter(0,1,2))

# or
# print(sorted(l, key=lambda a:(a[0],a[1],a[2])))

#---ignore---
# import collections
# shows duplicates and no of times they repeat
# collections.Counter(l2)
