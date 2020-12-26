This is a netBeans java project for implementing Stacks and Queues.

These are implemented using linked lists, fixed arrays and resizing arrays.

The classes contained are:

LinkedStackOfStrings: It uses a linked list to implement a stack of strings.

FixedCapacityStackOfStrings: It uses a fixed size array to implement a stack. Currently has a fixed
size of 100 strings, can be modified to take size as a parameter in constructor but that is not
a good implementation from a client's perspective.

ResizingArrayStackOfStrings: An improvement over fixed size array implementation of stack. The array
automatically grows and shrinks (by a factor of 2 when it reaches full size and 25% size respectively).
The client would not have to worry about defining the size of the stack. An improvement to this would
be a generic implementation that can be used for all data types, not just strings.

QueueOfStrings: It uses a linked list to implement a queue of strings.

ArrayQueueOfStrings: It uses a resizing array to implement a queue of strings.

The test classes are:

LinkedStackOfStringsTest, FixedCapacityStackOfStringsTest, ResizingArrayStackOfStringsTest, QueueOfStringsTest, ArrayQueueOfStringsTest - These classes are used to test the above implementations.
