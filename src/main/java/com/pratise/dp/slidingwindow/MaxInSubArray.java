package com.pratise.dp.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSubArray {
    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,2,3,6,7};
        int k=3;
        int i=0,j=0,max= Integer.MIN_VALUE;
        Deque<Integer> queue = new LinkedList<>();
        while(j<arr.length){


            while(queue.size()>0 && queue.peekLast()<arr[j]){
                queue.pollLast();
            }
            queue.add(arr[j]);
            if(j-i+1<k){
                j++;

            } else if(j-i+1==k){

                System.out.print(queue.peek()+" ");
                if(queue.peek()==arr[i]){
                    queue.pollFirst();
                }
                i++;
                j++;

            }
        }
    }
}
