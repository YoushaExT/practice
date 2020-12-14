# Please write a program to generate all sentences where subject is in ["I", "You"] and verb is in ["Play", "Love"] and
# the object is in ["Hockey","Football"].
#
# Hints: Use list[index] notation to get a element from a list.

sub = ['I','You']
verb = ['Play','Love']
obj = ['Hockey','Football']

# method 1
for i in sub:
    for j in verb:
        for k in obj:
            print(f"{i} {j} {k}.")

# method 2
# L=[]
# for i in sub:
#     L.append(i)
#     for j in verb:
#         L.append(j)
#         for k in obj:
#             L.append(k)
#             print(' '.join(L)+'.')
#             L.remove(k)
#         L.remove(j)
#     L.remove(i)
