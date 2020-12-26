package com.yousha.algo1.stacksandqueues;

public class ResizingArrayStackOfStrings {
    int n = 0;
    String[] str = new String[1];
    
    
    public void push(String s){

        if (this.n == this.str.length){
            resize(this.str.length*2);
        } 
        this.str[this.n++] = s;
    }
    public String pop(){

        String s = this.str[--this.n];
        str[this.n]=null;
        if (this.n > 0 && this.n == str.length/4){ //str.length/2 would also work but it would introduce thrashing ( a series of push and 
                                        //pop at boundary length causing repeated resizing)
            resize(this.str.length/2);
        }        
        
        return s;
    }
    public boolean isEmpty(){
        return n==0;
    }
    
    private void resize(int capacity){
        String[] copy = new String[capacity];
        
        for (int i = 0; i < this.n; i++){
            copy[i] = this.str[i];
        }
        this.str = copy;
    }
}
