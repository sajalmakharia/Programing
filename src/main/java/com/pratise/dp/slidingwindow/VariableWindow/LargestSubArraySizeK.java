package com.pratise.dp.slidingwindow.VariableWindow;

public class LargestSubArraySizeK {
    public static void main(String[] args) {
        int[] arr = {1,-1,3,5,-3,5};
        int sum = 10;
        int i=0,j=0,maxSize=0;
        int res=0;
        while(j< arr.length){
            res += arr[j];

            if(res<sum){
                j++;
            }else if(res==sum){
                maxSize = Integer.max(j-i+1,maxSize);
                j++;
            } else {
                while(sum<res) {
                    res -= arr[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println(maxSize);
    }
}
