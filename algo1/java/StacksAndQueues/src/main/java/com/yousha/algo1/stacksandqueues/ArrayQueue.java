package com.yousha.algo1.stacksandqueues;

public class ArrayQueue<Item> {
    
    private Item[] q = (Item[])new Object[1]; // private Item[] q = new Item[1]; not allowed in java
    
    public int size() {
        return q.length;
    }
    
    private int head = q.length;
    private int tail = q.length;
    
    public void enqueue(Item s){
        
        if(tail==q.length){
            resize(2*q.length);
        }
        q[tail] = s;
        tail++;
        

    }

    public Item dequeue(){
        if (isEmpty()) throw new IllegalArgumentException("Empty queue");
        Item s = q[head];
        head++;
//        System.out.println(head+" "+q.length);
        if (head>(3*q.length)/4 && q.length>4){
            resizeShrink(q.length/2);
        }
        return s;
    }
    public boolean isEmpty(){
        return this.head==this.tail;
    }    

    private void resize(int capacity){

//        Item[] copy = new Item[capacity]; <-- not allowed in java
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = head; i < tail; i++){

            copy[i]=this.q[i];
        }

        q = copy;

    }
    
    private void resizeShrink(int capacity){

        if (capacity == 0) return;

//        Item[] copy = new Item[capacity];
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < tail-head; i++){
            copy[i]=this.q[i+head];
        }
        head = 0;
        q = copy;

    }   
    
    
}
