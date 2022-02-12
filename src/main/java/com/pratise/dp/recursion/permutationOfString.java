package com.pratise.dp.recursion;

public class permutationOfString {
    public static void main(String[] args) {
        /*String a = "abc";
        permutation("",a);*/
        int[] ar={2,3,2};
        System.out.println(rob(ar));

    }
    static void permutation(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second = p.substring(i);
            permutation(first+ch+second,up.substring(1));
        }
    }

    static int rob(int[] num) {
        int n=num.length;
        if(n==0){
            return 0;
        }
        int first = num[0];

        if(n==1){
            return first;
        }
        int second = num[1];
        if(n==2){
            return Math.max(first,second);
        }

        int[] arr1 = new int[num.length];
        arr1[0]=first;
        arr1[1] = Math.max(first,second);

        for(int i=2;i<n-1;i++){
            arr1[i]=Math.max(num[i]+arr1[i-2],arr1[i-1]);
        }
        int[] arr2 = new int[num.length];
        arr2[0] = second;
        arr2[1] = Math.max(second,num[2]);
        for(int i=3;i<n;i++){
            arr2[i-1]=Math.max(num[i]+arr2[i-3],arr2[i-2]);
        }
        return Math.max(arr1[n-1],arr2[n-1]);


    }
}
