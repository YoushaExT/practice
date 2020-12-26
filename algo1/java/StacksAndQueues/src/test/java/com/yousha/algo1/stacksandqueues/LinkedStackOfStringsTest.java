package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackOfStringsTest {
    
    public LinkedStackOfStringsTest() {
    }

    @Test
    public void testPush() {
        // implemented in testPop()        
    }

    @Test
    public void testPop() {
        LinkedStackOfStrings ss = new LinkedStackOfStrings();        
        ss.push("My");
        assertEquals("My",ss.pop());
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        assertEquals("Yousha",ss.pop());
        assertEquals("is",ss.pop());
        assertEquals("name",ss.pop());
    } // this tests both push and pop

    @Test
    public void testIsEmpty() {
        LinkedStackOfStrings ss = new LinkedStackOfStrings();
        assertEquals(true, ss.isEmpty());
        ss.push("My");
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        assertEquals(false, ss.isEmpty());
    }
    
}
