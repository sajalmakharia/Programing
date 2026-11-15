package com.pratise.dp.slidingwindow.VariableWindow;

public class LargestSubArraySizeK {
    public static void main(String[] args) {
        int[] arr = {1,-1,3,5,-3,5};
        int sum = 10;
        int i=0,j=0,maxSize=0;
        int currentSum=0;
        while(j< arr.length){
            currentSum += arr[j];

            if(currentSum<sum){
                j++;
            }else if(currentSum==sum){
                maxSize = Integer.max(j-i+1,maxSize);
                j++;
            } else {
                while(sum<currentSum) {
                    res -= arr[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println(maxSize);
    }
}
