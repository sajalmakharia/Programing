package com.pratise.dp.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeSubArray {
    public static void main(String[] args) {
        int k=3;
        int[] arr= {12,-1,-7,8,-15,30,16,28};
        int i=0,j=0;
        List<Integer> neg = new ArrayList<>();
        while(j< arr.length){
            if(arr[j]<0){
                neg.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            } else if(j-i+1==k){
                if(neg.size()==0){
                    System.out.print(0+" ");
                } else {
                    System.out.print(neg.get(0)+" ");
                    if(neg.get(0)==arr[i]) {
                        neg.remove(0);
                    }
                }
                i++;
                j++;
            }

        }
    }
}
