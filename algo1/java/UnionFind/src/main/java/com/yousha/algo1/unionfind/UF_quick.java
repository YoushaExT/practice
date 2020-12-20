
package com.yousha.algo1.unionfind;

public class UF_quick {
    int[] id;
    public UF_quick(int n){
        this.id = new int[n];
        for(int i=0; i<n; i+=1){
            this.id[i]=i;
        }
    }
    
//    public static void main(String args[]){
//        System.out.println("Main function has been called");        
//    }
    
    public static int[] initializeArray(int n){
        UF_quick qf = new UF_quick(n);
        return qf.id;
    }

    public boolean connected(int p, int q){
        // compare id[p] and id[q] and return the boolean result
        return this.id[p]==this.id[q];
    }
    
    public void setArray(int[] arr){
        this.id=arr;
    }          
    
    public void printIds(){
//        for (int i=0; i<this.id.length; i+=1){
//            System.out.print(this.id[i]);
//        }
        for (int i: this.id){
            System.out.print(i);
        }
        System.out.println();
    }
    
    public void union(int p, int q){
        int pId = this.id[p];
        for (int i=0; i<this.id.length; i+=1){
            if (this.id[i]==pId){
                this.id[i]=this.id[q];
            }
        }
    }
    
}
