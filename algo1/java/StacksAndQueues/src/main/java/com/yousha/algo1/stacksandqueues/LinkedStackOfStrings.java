/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yousha.algo1.stacksandqueues;

/**
 *
 * @author Yousha
 */
public class LinkedStackOfStrings {
    
    private Node first=null;
    
    private class Node{        
        String value;
        Node next;
    }
    
    public void push(String s){        
        Node oldFirst = this.first;
        this.first = new Node();
        this.first.value = s;
        this.first.next = oldFirst;
    }
    public String pop(){
        String value = this.first.value;
        this.first = this.first.next;
        return value;
    }
    public boolean isEmpty(){
        return this.first == null;
    }

}
