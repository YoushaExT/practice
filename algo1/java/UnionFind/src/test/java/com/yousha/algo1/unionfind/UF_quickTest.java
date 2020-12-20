/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousha.algo1.unionfind;

import static com.yousha.algo1.unionfind.UF_quick.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import com.yousha.algo1.unionfind.UF_quick;

/**
 *
 * @author Yousha
 */
public class UF_quickTest {
    
    public UF_quickTest() {
    }

    /**
     * Test of main method, of class UF_quick.
     */
//    @Test
//    public void testMain() {        
//
//    }

    /**
     * Test of initializeArray method, of class UF_quick.
     */
    @Test
    public void testInitializeArray() {
//        int n = 10;
//        int[] initialArray = initializeArray(n);
//        
//        //        print initial array
//        for(int i=0; i<n; i+=1){
//            System.out.print(initialArray[i]);
//        }
        int[] expected = {0,1,2,3,4,5,6,7,8,9};

        assertArrayEquals(expected, initializeArray(10));
    }
    
    @Test
    public void testConnected(){
//        initializing nodes
        int[] nodes = {0,1,8,3,4,9,6,9,8,9};
        
        UF_quick qf = new UF_quick(10);
        qf.printIds();

        qf.setArray(nodes);
        qf.printIds();
        
//        nodes 0-1, 2(8)-3 are not connected, nodes 2-8,7-9 are connected
//        so connected(0,1) and(2,3) return false (2,8)(7,9) return true
        assertEquals(false, qf.connected(0,1));
        assertEquals(false, qf.connected(2,3));
        assertEquals(true, qf.connected(2,8));
        assertEquals(true, qf.connected(7,9));
    }// test passed meaning the connected() method implementation was correct.

    /**
     * Test of setArray method, of class UF_quick.
     */
    @Test
    public void testSetArray() {
    }

    /**
     * Test of printIds method, of class UF_quick.
     */
    @Test
    public void testPrintIds() {
    }

    /**
     * Test of union method, of class UF_quick.
     */
    @Test
    public void testUnion() {
        // if a union is successful id of p should become id of q
        //{0,1,8,3,4,9,6,9,8,9} calling union(1,2) id of 1 should change from
        //1 to 8 then calling union(2,3) should create array {0,3,3,3,4,9,6,9,3,9}
        int[] expected = {0,8,8,3,4,9,6,9,8,9};
        
        //initialize
        int[] nodes = {0,1,8,3,4,9,6,9,8,9};        
        UF_quick qf = new UF_quick(10);
        qf.setArray(nodes);
        //begin main testing
        qf.union(1,2);
        assertArrayEquals(expected,qf.id);
        
        int[] expected2 = {0,3,3,3,4,9,6,9,3,9};
        expected = expected2;
        //expected = {0,3,3,3,4,9,6,9,3,9}; <-- for some reason this is'nt allowed
        qf.union(2, 3);
        assertArrayEquals(expected,qf.id);
        
        qf.union(9, 8);        
        int[] expected3 = {0,3,3,3,4,3,6,3,3,3};
        expected = expected3; //hopefully this saves memory
        assertArrayEquals(expected,qf.id);
        
    }
    
    
}
