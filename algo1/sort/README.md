This folder contains some sorting algorithm implementations in python.

Insertion and Selection sorts run in quadratic worst-case time (O(N<sup>2</sup>)).

Shell sort runs in sub-quadratic worst-case time (O(N<sup>1.5</sup>)).

Quick sort runs in linearithmic time (O(NlogN)) in average case and quadratic time (O(N<sup>2</sup>)) in the worst case but that
is extremely unlikely for big arrays. (Since we uniformly shuffle before sorting)

Merge sort runs in linearithmic worst-case time (O(NlogN)). It is stable but uses extra space. In practice it is slower than Quick sort.

test.py can be run to benchmark these algorithms to sort a random array of size 4000.

The algorithms do not perform as well as their java implementations because python data structures are different.
For example, in java fixed size arrays were used to create a new auxilliary array but in python a list is used which would dynamically grow
and elements would have to be moved multiple times whenever the size increases. (Also afaik the resizing factor is 1.125 + 6 which favors memory over time)
