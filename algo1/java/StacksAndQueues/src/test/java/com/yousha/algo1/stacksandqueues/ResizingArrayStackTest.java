package com.yousha.algo1.stacksandqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResizingArrayStackTest {
    
    public ResizingArrayStackTest() {
    }

    @Test
    public void testPush() {
    }

    @Test
    public void testPop() {
        ResizingArrayStack ss = new ResizingArrayStack();
        ss.push("My");
        assertEquals("My",ss.pop());
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        ss.push(11);
        ss.push(420);
        assertEquals(420,ss.pop());
        assertEquals(11,ss.pop());
        assertEquals("Yousha",ss.pop());
        assertEquals("is",ss.pop());
        assertEquals("name",ss.pop());
    }


    @Test
    public void testIsEmpty() {
        ResizingArrayStack ss = new ResizingArrayStack();
        
        assertEquals(true, ss.isEmpty());
        ss.push("My");
        ss.push("name");
        ss.push("is");
        ss.push("Yousha");
        assertEquals(false, ss.isEmpty());    
        
    }
    
}
