package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    
    public QueueTest() {
    }

    @Test
    public void testEnqueue() {
    }

    @Test
    public void testDequeue() {
        Queue ss = new Queue();        
        ss.enqueue("My");
        assertEquals("My",ss.dequeue());
        ss.enqueue("name");
        ss.enqueue("is");
        ss.enqueue("Yousha");
        ss.enqueue(420);
        ss.enqueue(322);
        ss.enqueue("noice");
        assertEquals("name",ss.dequeue());
        assertEquals("is",ss.dequeue());
        assertEquals("Yousha",ss.dequeue());
        assertEquals(420,ss.dequeue());
        assertEquals(322,ss.dequeue());
        assertEquals("noice",ss.dequeue());
    }

    @Test
    public void testIsEmpty() {
        Queue ss = new Queue();
        assertEquals(true, ss.isEmpty());
        ss.enqueue("My");
        ss.enqueue("name");
        ss.enqueue("is");
        ss.enqueue("Yousha");
        assertEquals(false, ss.isEmpty());
    }
    
}
