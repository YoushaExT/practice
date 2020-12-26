package com.yousha.algo1.stacksandqueues;

public class FixedCapacityStackOfStrings {
    String[] str = new String[100];
    int n = 0;
    public void push(String s){
//        str[n]=s;
//        n++;
        str[n++]=s; // same as the above two expressions
    };
    public String pop(){
////        n--;
////        String s = str[n];
////        return s;
//        return str[--n]; // same as the above three expressions (still has loitering)
        String s = str[--n];
        str[n] = null; // this prevents loitering by allowing garbage collector to claim unused value (frees memory)
        return s;
    };
    public boolean isEmpty(){return n==0;}    
}
