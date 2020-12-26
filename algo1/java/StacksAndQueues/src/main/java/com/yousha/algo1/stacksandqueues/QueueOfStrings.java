package com.yousha.algo1.stacksandqueues;

public class QueueOfStrings {
    
    private Node first, last;
    
    private class Node{
        String value;
        Node next;
    }

// // The commented code also works but naming is incorrect (last is named first and first is named last)
// // and also bad implementation bcz of while loop    
//    public void enqueue(String s){
//        Node Oldfirst = this.first;
//        this.first = new Node();
//        this.first.value = s;
//        this.first.next = Oldfirst;
//        
//        this.last = first;
//        
//        while(last.next != null){
//            this.last = last.next;
//        }
//    }
     public void enqueue(String s){
        
        Node Oldlast = this.last;
        this.last = new Node();        
        this.last.value = s;
        this.last.next = null;
        
        if (isEmpty()) first = last; // on the first call this will always be true
        else Oldlast.next = this.last;
         
     }
//    public String dequeue(){
//        String s = this.last.value;
//        this.last = this.first;
//        while(last.next != null){
//            if(this.last.next.next == null) break;
//            this.last = last.next;
//        }//last becomes second last
//        this.last.next = null;
//        return this.last.value;
//    }
    public String dequeue(){
        String value = this.first.value;
        this.first = this.first.next;
        if (isEmpty()) last = null; // if there was only 1 item, first<-first.next will be null so condition is false
        return value;
    }
    public boolean isEmpty(){
        return this.first == null;
    }
    
}