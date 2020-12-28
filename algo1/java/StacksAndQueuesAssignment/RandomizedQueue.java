/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // public class RandomizedQueue<Item> {

    private int first;
    private Item[] d;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.d = (Item[]) new Object[1];
        first = 0;
        // this.size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        // return this.size == 0;
        return this.first == 0;
    }

    // // return the number of items on the randomized queue
    public int size() {
        // return this.size;
        return this.first;
    }

    // add the item
    public void enqueue(Item item) {
        // testing
        // StdOut.print(d.length + "  ");

        checkNull(item);
        if (this.first == this.d.length - 1) {
            // increase array length
            resize(2 * this.d.length);
        }
        this.d[this.first] = item;
        this.first++;

        // testing
        // StdOut.println(item + "  " + d.length);
    }

    // remove and return a random item
    public Item dequeue() {
        // testing
        // StdOut.print(d.length + "  ");

        // if (isEmpty()) throw new NoSuchElementException();
        checkElement();
        int num1 = StdRandom.uniform(0, this.first); // random array number 0 to first(not included)
        // swap num1 and first number
        Item temp = d[num1];
        this.first--;
        this.d[num1] = d[this.first]; // overwrite instead of delete

        this.d[this.first] = null; // todo loitering fix
        // shrink if needed
        if (this.first > 0 && this.first == (0.25 * this.d.length) - 1) resize(this.d.length / 2);

        // testing
        // StdOut.println(temp + "  " + d.length);
        return temp;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        // if (isEmpty()) throw new NoSuchElementException();
        checkElement();
        // int num1 = StdRandom.uniform(0, this.first); // random array number 0 to first(not included)
        // return d[num1];

        return this.d[StdRandom.uniform(0, this.first)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {

        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int fc;
        private Item[] dc;

        /*
            knuth shuffle:
        -- To shuffle an array a of n elements (indices 0..n-1):

        for i from n−1 downto 1 do
             j ← random integer such that 0 ≤ j ≤ i
             exchange a[j] and a[i]

        */
        // todo private?
        private RandomizedQueueIterator() {

            // this.dc = (Item[]) new Object[d.length];
            this.dc = (Item[]) new Object[size() + 1]; // todo memory fix?
            this.fc = first;

            // make a copy of the original array
            for (int i = 0; i < first; i++) {
                this.dc[i] = d[i];
            }
        }

        public boolean hasNext() {
            return !isEmptyCopy(); // = !isEmpty but for the copy instead
        } // k

        public void remove() {
            throw new UnsupportedOperationException("uncool");
            // not recommended
        } // k

        public Item next() {
            return dequeueCopy();
        } // k

        public Item dequeueCopy() {

            checkElementCopy();
            int num1 = StdRandom
                    .uniform(0, this.fc); // random array number 0 to first(not included)
            // swap num1 and first number
            Item temp = this.dc[num1];
            this.fc--;
            this.dc[num1] = this.dc[this.fc]; // overwrite instead of delete

            this.dc[this.fc] = null; // todo loitering fix
            // shrink if needed
            // if (this.fc > 0 && this.fc == (0.25 * this.dc.length) - 1)
            //     resizeCopy(this.dc.length / 2);

            if (this.fc > 0 && this.fc == (int) (0.5 * this.dc.length)
                    - 1) // todo memory fix 2? e.g. if len =7 7/2=3.5->int->3;3-1=2 when index is 2
            {
                resizeCopy(this.dc.length / 2); // e.g. 7/2 = 3.5 auto casted to int -> 3
            }

            return temp;
        }

        private void checkElementCopy() {
            if (isEmptyCopy()) {
                throw new NoSuchElementException("Element doesn't exist");
            }
        } // k

        public boolean isEmptyCopy() {
            // return this.size == 0;
            return this.fc == 0;
        }


        private void resizeCopy(int capacity) {
            Item[] copy = (Item[]) new Object[capacity];
            for (int i = 0; i < fc; i++) {
                copy[i] = this.dc[i];
            }
            this.dc = copy;

        }

    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < first; i++) {
            copy[i] = this.d[i];
        }
        this.d = copy;

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
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        // StdOut.println(" " + rq.size());


        StdOut.println(rq.isEmpty());
        StdOut.println(rq.size());
        rq.enqueue(2);
        // StdOut.println(" " + rq.size());
        rq.enqueue(4);
        rq.enqueue(6);
        rq.enqueue(8);
        rq.enqueue(10);
        rq.enqueue(12);
        rq.enqueue(14);
        rq.enqueue(16);
        StdOut.println(rq.isEmpty());
        StdOut.println(rq.size());
        // StdOut.println(" " + rq.size());
        for (int i : rq) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        rq.enqueue(1);
        // StdOut.println(" " + rq.size());
        rq.enqueue(3);
        rq.enqueue(5);
        rq.enqueue(7);
        rq.enqueue(9);
        rq.enqueue(11);
        rq.enqueue(13);
        rq.enqueue(15);
        StdOut.println();
        for (int i : rq) {
            StdOut.print(i + " ");
        }
        StdOut.println();

        rq.enqueue(2);
        // StdOut.println(" " + rq.size());
        rq.enqueue(4);
        rq.enqueue(6);
        rq.enqueue(8);
        rq.enqueue(10);
        rq.enqueue(12);
        rq.enqueue(14);
        rq.enqueue(16);

        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println();
        StdOut.println();
        // StdOut.println(" " + rq.size());

        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        // StdOut.println(" " + rq.size());


    }

}

// no need to shift the whole array on removal remove from pool of generated numbers

// every iterator has its own copy of first index
