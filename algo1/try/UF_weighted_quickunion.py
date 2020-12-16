# in weighted quick union we'll make sure that always the smaller tree gets attached to the larger tree to minimize the average distance
# from root node, root function calls go from N to log N


class UF_wqu:
    def __init__(self,n):
        self.n=n
        self.id=[x for x in range(n)]
        self.sz=[1 for x in range(n)] #size of each root

    def connected(self,p,q):
        #if root of p equals root of q
        return self.root(p)==self.root(q)

    def union(self,p,q):
        # set root of p to root of q
        i=self.root(p)
        j=self.root(q)

        if i==j: #if already connected
            return
        if self.sz[i]<self.sz[j]: #if p is smaller p connects to q
            self.id[i]=j #root(p) points to root(q)
            self.sz[j]+=self.sz[i] #q becomes bigger
        else:
            self.id[j]=i
            self.sz[i]+=self.sz[j]



    def root(self,o):
        #need to find root->root->root->root ... till root doesnt change
        while self.id[o]!=o: #if not different
            o=self.id[o] #move object up 1 level in the tree
        return o #when matches return


qf = UF_wqu(10) #create a qf object with 10 nodes

print(qf.id)
# same connections as coursera lecture:
qf.union(4,3)

qf.union(3,8)
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

# for i in qf.id:
#     print(qf.root(i))
# print(qf.id)
