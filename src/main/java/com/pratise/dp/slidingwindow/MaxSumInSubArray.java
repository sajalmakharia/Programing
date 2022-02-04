package com.pratise.dp.slidingwindow;

public class MaxSumInSubArray {

    public static void main(String[] args) {

        int k=3;
        int[] arr= {5,5,3,8,2,0,1};
        int sum=0,maxSum=0,i=0,j=0;
        while(j< arr.length){
            sum +=arr[j];
            if(j-i+1<k){
                j++;

            } else
            if(j-i+1==k){
                maxSum=Math.max(maxSum,sum);
                sum = sum-arr[i];
                i++;
                j++;
            }

        }
        /*for(i=0;i<k;i++){
            sum += arr[i];
        }
        maxSum=sum;
        for(int i=1;i<arr.length-k+1;i++){
            sum = sum-arr[i-1]+arr[i+k-1];
            if(maxSum<sum){
                maxSum=sum;
            }
        }*/
        System.out.println(maxSum);

    }
}
