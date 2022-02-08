package com.pratise.dp.slidingwindow.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(sub("","abc"));
    }
    public static ArrayList<String> sub(String process,String unProcess){
        if(unProcess.isEmpty()){
            return new ArrayList<>(Collections.singletonList(process));
        }
        ArrayList<String> left = sub(process+unProcess.charAt(0),unProcess.substring(1));
        ArrayList<String> right =sub(process,unProcess.substring(1));
        left.addAll(right);
        return left;
    }
}
