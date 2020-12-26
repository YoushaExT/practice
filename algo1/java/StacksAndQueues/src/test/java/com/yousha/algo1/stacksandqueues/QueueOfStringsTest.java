/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueOfStringsTest {
    
    public QueueOfStringsTest() {
    }

    @Test
    public void testEnqueue() {
    }

    @Test
    public void testDequeue() {
        QueueOfStrings ss = new QueueOfStrings();        
        ss.enqueue("My");
        assertEquals("My",ss.dequeue());
        ss.enqueue("name");
        ss.enqueue("is");
        ss.enqueue("Yousha");
        assertEquals("name",ss.dequeue());
        assertEquals("is",ss.dequeue());
        assertEquals("Yousha",ss.dequeue());
    }

    @Test
    public void testIsEmpty() {
        QueueOfStrings ss = new QueueOfStrings();
        assertEquals(true, ss.isEmpty());
        ss.enqueue("My");
        ss.enqueue("name");
        ss.enqueue("is");
        ss.enqueue("Yousha");
        assertEquals(false, ss.isEmpty());
    }
    
}
