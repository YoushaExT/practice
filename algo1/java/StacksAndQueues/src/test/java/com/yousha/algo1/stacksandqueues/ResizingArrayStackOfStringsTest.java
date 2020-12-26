package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResizingArrayStackOfStringsTest {
    
    public ResizingArrayStackOfStringsTest() {
    }

    @Test
    public void testPush() {
    }

    @Test
    public void testPop() {
        ResizingArrayStackOfStrings ss = new ResizingArrayStackOfStrings();
        ss.push("My");
        assertEquals("My",ss.pop());
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        assertEquals("Yousha",ss.pop());
        assertEquals("is",ss.pop());
        assertEquals("name",ss.pop());
    }


    @Test
    public void testIsEmpty() {
        ResizingArrayStackOfStrings ss = new ResizingArrayStackOfStrings();
        
        assertEquals(true, ss.isEmpty());
        ss.push("My");
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        assertEquals(false, ss.isEmpty());    
        
    }
    
}
