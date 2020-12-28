/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size; // size of no of items in queue

    private class Node {
        private Item value;
        private Node next;
        private Node prev;
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    } // k

    // is the deque empty?
    public boolean isEmpty() {
        return this.first == null;
    } // k

    // return the number of items on the deque
    public int size() {
        return this.size;
    } // k

    // add the item to the front
    public void addFirst(Item item) {
        checkNull(item);
        //todo
        Node oldFirst = this.first; // store old ptr
        this.first = new Node(); // point to new ptr
        this.first.value = item; // store the input
        this.first.prev = null; // no previous of first
        this.first.next = oldFirst; // establish link to the 2nd element

        if (oldFirst == null) this.last = this.first; // special case for first insertion
        else {
            oldFirst.prev = this.first; // establish reverse link
        }
        this.size++; // queue size increased by 1

    } // k

    // add the item to the back
    public void addLast(Item item) {
        checkNull(item);
        //todo
        Node oldLast = this.last;
        this.last = new Node();
        this.last.value = item; // store the input
        this.last.next = null; // nothing after last
        this.last.prev = oldLast; // establish link to the 2nd last element

        if (oldLast == null) this.first = this.last; // special case for first insertion
        else {
            oldLast.next = this.last; // establish reverse link
        }
        this.size++; // queue size increased by 1
    } // k

    // remove and return the item from the front
    public Item removeFirst() {
        checkElement();
        //todo
        Item item = this.first.value; // copy the value
        this.first = this.first.next; // 2nd is the new 1st

        if (this.first == null) this.last = null;
        else {
            this.first.prev = null; // remove links from the deleted node
        }
        this.size--; // queue size decreased
        return item;
    } // k

    // remove and return the item from the back
    public Item removeLast() {
        checkElement();
        //todo
        Item item = this.last.value;
        this.last = this.last.prev;

        if (this.last == null) this.first = null;
        else {
            this.last.next = null;
        }
        this.size--; // queue size decreased
        return item;
    } // k

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    } // k

    private class DequeIterator implements Iterator<Item> {

        private Node firstCopy;
        // private int sizeCopy; // not needed

        private DequeIterator() {
            this.firstCopy = first;
            // this.lastCopy = last; // don't need last because we are not adding anything
            // this.sizeCopy = size;

        }

        public boolean hasNext() {
            return !isEmptyCopy();
        } // k

        public void remove() {
            throw new UnsupportedOperationException("uncool");
            // not recommended
        } // k

        public Item next() {
            return removeFirstCopy();
        } // k


        private Item removeFirstCopy() {

            checkElementCopy();
            //todo
            Item item = this.firstCopy.value; // copy the value
            this.firstCopy = this.firstCopy.next; // 2nd is the new 1st

            // if (this.firstCopy == null) this.lastCopy = null;

            // this.sizeCopy--; // not needed
            return item;

        }

        // is the deque COPY empty?
        private boolean isEmptyCopy() {
            return this.firstCopy == null;
        } // k

        private void checkElementCopy() {
            if (isEmptyCopy()) {
                throw new NoSuchElementException("Element doesn't exist");
            }
        } // k

    }


    private void checkNull(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Go away null no one wants you");
        }
    } // k

    private void checkElement() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element doesn't exist");
        }
    } // k


    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();

        // dq.removeFirst(); throws NoSuchElementException
        // dq.removeLast(); throws NoSuchElementException
        StdOut.println(dq.size());
        StdOut.println(dq.isEmpty());
        int[] myInput = { 2, 4, 6, 8, 10, 12 };

        for (int values : myInput) {
            dq.addFirst(values);
        }

        // dq.addFirst(null); // throws IllegalArgumentException
        // dq.addLast(null); // throws IllegalArgumentException

        int[] myInput2 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        for (int values : myInput2) {
            dq.addFirst(values);
        }
        StdOut.println(dq.size());
        StdOut.println(dq.isEmpty());

        // String[] myInput3 = { "apple", "orange", "potato", "tomato" };
        //
        // for (String values : myInput3) {
        //     dq.addLast(values);
        // }

        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeLast());

        StdOut.println(dq.size());
        StdOut.println(dq.isEmpty());


        // int[] myInput2 = { 2, 3, 5, 7, 11 };
        //
        // for (int values : myInput2) {
        //     dq.addLast(values);
        // }
        //
        // StdOut.println(dq.removeFirst());
        //
        // for (Object i : dq) {
        //     StdOut.print(" " + i);
        // }
        for (Object i : dq) {
            StdOut.print(" " + i);
        }

        StdOut.println();

        for (Object i : dq) {
            StdOut.print(" " + i);
        }
        // Iterator iter = dq.iterator();
        // while (iter.hasNext()) {
        //     Object j = iter.next();
        //     StdOut.println(j);
        // }
        // StdOut.println(i.hasNext());
        // StdOut.println(iter.next()); // throws NoSuchElementException
        // iter.remove(); // throws UnsupportedOperationException

    }
}
