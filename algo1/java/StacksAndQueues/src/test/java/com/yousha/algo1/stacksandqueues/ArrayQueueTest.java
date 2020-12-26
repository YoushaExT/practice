package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    
    public ArrayQueueTest() {
    }

    @Test
    public void testDequeue() {
//        ArrayQueue<String> ss = new ArrayQueue<>(); 
        ArrayQueue ss = new ArrayQueue(); // don't need to type<String>, it is automatically detected by input

        System.out.println(" "+ss.size());
        ss.enqueue("1");//size2
        System.out.println(" "+ss.size());
        ss.enqueue("2");//size4
        System.out.println(" "+ss.size());
        ss.enqueue("3");//size4
        System.out.println(" "+ss.size());
        ss.enqueue("4");//size8
        System.out.println(" "+ss.size());
        ss.enqueue("5");//8
        ss.enqueue("6");//8
        ss.enqueue("7");//8
        ss.enqueue(8);

        System.out.println(" "+ss.size());
        
        assertEquals("1",ss.dequeue());//size8
        System.out.println(" "+ss.size());
        assertEquals("2",ss.dequeue());//8
        System.out.println(" "+ss.size());
        assertEquals("3",ss.dequeue());//8
        System.out.println(" "+ss.size());
        assertEquals("4",ss.dequeue());//8
        System.out.println(" "+ss.size());
        assertEquals("5",ss.dequeue());//8
        System.out.println(" "+ss.size());
        assertEquals("6",ss.dequeue());//size4 -2/8 25% capacity so change size to 50%
        System.out.println(" "+ss.size());
        assertEquals("7",ss.dequeue());
        assertEquals(8,ss.dequeue()); // now the queue can contain a mixture of strings and ints similar to python lists
        // assertEquals("8",ss.dequeue());//this will give error
        // expected: java.lang.String@1963006a<8> but was: java.lang.Integer@7fbe847c<8>

        
        
//        LinkedStack<Integer> si = new LinkedStack<>();  //<> diamond notation instead of writing <Integer> twice        
//        
//        si.push(51);
//        assertEquals(51,si.pop());
//        si.push(2);
//        si.push(3);
//        si.push(5);        
//        assertEquals(5,si.pop());
//        assertEquals(3,si.pop());
//        assertEquals(2,si.pop());

    }

    @Test
    public void testIsEmpty() {
        ArrayQueueOfStrings ss = new ArrayQueueOfStrings();
        assertEquals(true, ss.isEmpty());
        ss.enqueue("My");
        ss.enqueue("name");
        ss.enqueue("is");
        ss.enqueue("Yousha");
        assertEquals(false, ss.isEmpty());
    }
    
}
