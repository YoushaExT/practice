This folder contains some sorting algorithm implementations in python.

The algorithms do not perform as well as their java implementations because python data structures are different.
For example, in java fixed size arrays were used to create a new auxilliary array but in python a list is used which would dynamically grow
and elements would have to be moved multiple times whenever the size increases. (Also afaik the resizing factor is 1.125 + 6 which favors memory over time)

test.py can be run to benchmark these algorithms to sort a random array of size 4000.
