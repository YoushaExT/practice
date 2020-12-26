
package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    @Test
    public void testPush() {
        // implemented in testPop()        
    }

    @Test
    public void testPop() {
        LinkedStack<String> ss = new LinkedStack<String>();        
        ss.push("My");
        assertEquals("My",ss.pop());
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");        
        assertEquals("Yousha",ss.pop());
        assertEquals("is",ss.pop());
        assertEquals("name",ss.pop());
        
        //Using the same class for a stack of integers
        LinkedStack<Integer> si = new LinkedStack<>();  //<> diamond notation instead of writing <Integer> twice        
        
        si.push(51);
        assertEquals(51,si.pop());
        si.push(2);
        si.push(3);
        si.push(5);        
        assertEquals(5,si.pop());
        assertEquals(3,si.pop());
        assertEquals(2,si.pop());
    } // this tests both push and pop

    @Test
    public void testIsEmpty() {
        LinkedStack ss = new LinkedStack();
        assertEquals(true, ss.isEmpty());
        ss.push("My");
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        assertEquals(false, ss.isEmpty());
    }
    
}
