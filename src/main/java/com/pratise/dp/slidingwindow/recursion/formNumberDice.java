package com.pratise.dp.slidingwindow.recursion;

public class formNumberDice {
    public static void main(String[] args) {
        diceComb("",4);
    }
    static void diceComb(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 &&i<=target; i++) {
            diceComb(p+i,target-i);
        }
    }
}
