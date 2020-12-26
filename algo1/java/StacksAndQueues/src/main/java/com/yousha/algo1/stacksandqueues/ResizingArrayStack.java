package com.yousha.algo1.stacksandqueues;

public class ResizingArrayStack<Item> {
    
    int n = 0;
    Item[] str = (Item[])new Object[1];
    
    
    public void push(Item s){

        if (this.n == this.str.length){
            resize(this.str.length*2);
        } 
        this.str[this.n++] = s;
    }
    public Item pop(){

        Item s = this.str[--this.n];
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
        Item[] copy = (Item[]) new Object[capacity];
        
        for (int i = 0; i < this.n; i++){
            copy[i] = this.str[i];
        }
        this.str = copy;
    }
    
    
    
}
