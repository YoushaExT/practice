This is a netBeans java project for implementing Stacks and Queues.

These are implemented using linked lists, fixed arrays and resizing arrays.

The classes contained are:

**LinkedStackOfStrings:** It uses a linked list to implement a stack of strings.

**FixedCapacityStackOfStrings:** It uses a fixed size array to implement a stack. Currently has a fixed
size of 100 strings, can be modified to take size as a parameter in constructor but that is not
a good implementation from a client's perspective.

**ResizingArrayStackOfStrings:** An improvement over fixed size array implementation of stack. The array
automatically grows and shrinks (by a factor of 2 when it reaches full size and 25% size respectively).
The client would not have to worry about defining the size of the stack. An improvement to this would
be a generic implementation that can be used for all data types, not just strings.

**QueueOfStrings:** It uses a linked list to implement a queue of strings.

**ArrayQueueOfStrings:** It uses a resizing array to implement a queue of strings.

**LinkedStack:** It uses a linked list to implement a generic stack, values of different data types such as Integer and String can be pushed to the stack.

**ArrayQueue:** It uses a resizing array to implement a generic queue.

**ResizingArrayStackOfStrings:** It uses a resizing array to implement a generic stack.

The **test classes** are:

**LinkedStackOfStringsTest, FixedCapacityStackOfStringsTest, ResizingArrayStackOfStringsTest, QueueOfStringsTest, ArrayQueueOfStringsTest** - These classes are used to test the above implementations.

To implement a generic class:

1) add \<myGenericItem\> beside the class name declaration (e.g. class Stack{} becomes class stack\<Item\>{})
  
2) replace all specific data types(e.g. String, int) in declaration with the name enclosed in diamond brackets (e.g. Item instead of String)

3) In case on an array, create a new instance of Object class and cast it to Item[]. ( private Item[] q = new Item[N] instead of private String[] q = new String[N] would not work in java - so instead use - private Item[] q = **(Item[]) new Object[N];**
