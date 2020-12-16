# while quickfind focuses on faster find method but slower union method, quickunion has faster union method with only
# 1 value change but slower find method


class UF_qu:
    def __init__(self,n):
        self.n=n
        self.id=[x for x in range(n)]

    def connected(self,p,q):
        #if root of p equals root of q
        return self.root(p)==self.root(q)

    def union(self,p,q):
        # set root of p to root of q
        self.id[self.root(p)]=self.root(q)

    def root(self,o):
        #need to find root->root->root->root ... till root doesnt change
        while self.id[o]!=o: #if not different
            o=self.id[o] #move object up 1 level in the tree
        return o #when matches return


qf = UF_qu(10) #create a qf object with 10 nodes

print(qf.id)
# same connections as coursera lecture:
qf.union(4,3)

qf.union(3,8)
# print(qf.id)
qf.union(6,5)
qf.union(9,4)
qf.union(2,1)
print(qf.connected(8,9))
print(qf.connected(5,0))
qf.union(5,0)
qf.union(7,2)
qf.union(6,1)
qf.union(7,3)
print(qf.id)

for i in qf.id:
    print(qf.root(i))
# print(qf.id)


# print(qf.id)
# print(qf.connected(2,5))
# qf.union(2,5)
# print(qf.id)
# print(qf.connected(2,5))
# qf.union(1,5)
# print(qf.id)
