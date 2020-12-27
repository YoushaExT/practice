package com.yousha.algo1.stacksandqueues;

public class Queue<Item> {
    
    private Node first, last;
    
    private class Node{
        Item value;
        Node next;
    }

     public void enqueue(Item s){
        
        Node Oldlast = this.last;
        this.last = new Node();        
        this.last.value = s;
        this.last.next = null;
        
        if (isEmpty()) first = last; // on the first call this will always be true
        else Oldlast.next = this.last;
         
     }

    public Item dequeue(){
        Item value = this.first.value;
        this.first = this.first.next; // for the last dequeue first will become null but we also need to make last null
                                      // which is done in the next statement
        if (isEmpty()) last = null; // if there was only 1 item, first<-first.next will be null so condition is false                            
        return value;
    }
    public boolean isEmpty(){
        return this.first == null;
    }
    
    
}
