package com.pratise.dp.slidingwindow.iteration;

// to find the nth number whose factor can be only 2 or 3 or 5
public class UglyNumber {
    public static void main(String[] args) {
        int n=10;
        int i=1,j=1,k=1;
        int[] ugly = new int[n];
        int next=0;
        for(int i1=0;i1<n;i1++){
            next = Math.min(Math.min(2*i,3*j),5*k);
            ugly[i1]=next;
            i=(next==2*i)?++i:i;
            j=(next==3*j)?++j:j;
            k=(next==5*k)?++k:k;
        }
       /* for(int a=0;a<n;a++){
            System.out.print(ugly[a]+" ");
        }*/
        System.out.println(ugly[n-1]);
    }
}
