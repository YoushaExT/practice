import random


def isSorted(a):
    for i in range(len(a) - 1):
        if a[i] >= a[i + 1]:
            return False
    return True


def knuth_shuffle(a):
    num = len(a)
    for i in range(num):
        index = int(random.uniform(0, i+1))
        # index = random.randint(0, i)
        a[i], a[index] = a[index], a[i]
    return a
