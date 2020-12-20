This is a netBeans java project for implementing UnionFind algorithms.
UnionFind is used to check for connectivity between two points.

Some of its implementations are:

Quick find - focus on faster find() method - quadratic time

Quick union - focus on faster union() method - quadratic time

Weighted quick union - logarithmic time

Weighted quick union path compression (WQUPC) - log star time*

A Quick find class 'UF_quick' is create and its methods are tested using 'UF_quickTest' class,
junit library is used to implement @Test and 'assert' functions.

*-log star N (log*N) means numbers of times u need to take log to get 0 log(log(log(log(log(2^65536))))=5 so log star 2^65536=5
