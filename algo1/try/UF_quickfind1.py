# need to implement two methods
# union and connected
# connected will have if ids match
# union will make id[q] to equal id[p]


class UF_quick:
    def __init__(self,n):
        self.n=n
        self.id=[x for x in range(n)]

    def connected(self,p,q):
        return self.id[p]==self.id[q]

    def union(self,p,q):
        p_id=self.id[p]
        # find all the objects with the id=id[p] and change it to id[q]
        for i in range(len(self.id)):
            if self.id[i]==p_id: #when id matches id[p] change it to id[q]
                self.id[i]=self.id[q]


qf = UF_quick(10) #create a qf object with 10 nodes

# same connections as coursera lecture:
qf.union(3,4)
qf.union(3,8)
print(qf.id)
qf.union(6,5)
qf.union(9,4)
qf.union(2,1)
qf.connected(8,9)
qf.connected(5,0)
qf.union(5,0)
qf.union(7,2)
qf.union(6,1)
print(qf.id)


# print(qf.id)
# print(qf.connected(2,5))
# qf.union(2,5)
# print(qf.id)
# print(qf.connected(2,5))
# qf.union(1,5)
# print(qf.id)
