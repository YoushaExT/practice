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
public class LinkedStack<Item> {    
    private Node first=null;
    
    private class Node{        
        Item value;
        Node next;
    }
    
    public void push(Item s){        
        Node oldFirst = this.first;
        this.first = new Node();
        this.first.value = s;
        this.first.next = oldFirst;
    }
    public Item pop(){
        Item value = this.first.value;
        this.first = this.first.next;
        return value;
    }
    public boolean isEmpty(){
        return this.first == null;
    }
}
