package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueOfStringsTest {
    
    public ArrayQueueOfStringsTest() {
    }

    @Test
    public void testEnqueue() {
    }

    @Test
    public void testDequeue() {
        ArrayQueueOfStrings ss = new ArrayQueueOfStrings(); 

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
