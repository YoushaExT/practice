
package com.yousha.algo1.stacksandqueues;

public class ArrayQueueOfStrings {
            
    private String[] q = new String[1];
    
    public int size() {
        return q.length;
    }
    
    private int head = q.length;
    private int tail = q.length;
    
    public void enqueue(String s){
        
        if(tail==q.length){
            resize(2*q.length);
        }
        q[tail] = s;
        tail++;
        

    }

    public String dequeue(){
        if (isEmpty()) return "EMPTY!!";
        String s = q[head];
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

        String[] copy = new String[capacity];
        for (int i = head; i < tail; i++){

            copy[i]=this.q[i];
        }

        q = copy;

    }
    
    private void resizeShrink(int capacity){

        if (capacity == 0) return;

        String[] copy = new String[capacity];
        for (int i = 0; i < tail-head; i++){
            copy[i]=this.q[i+head];
        }
        head = 0;
        q = copy;

    }    
}
