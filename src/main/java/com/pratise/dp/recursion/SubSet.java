package com.pratise.dp.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subsetDuplicate(arr));

    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){
            int size = outer.size();
            for(int i=0;i<size;i++){
                List<Integer> inter = new ArrayList<>(outer.get(i));
                inter.add(num);
                outer.add(inter);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0,end=0;
        for(int i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start = end+1;
            }
            end=outer.size()-1;
            int size = outer.size();
            for(int j=start;j<size;j++){
                List<Integer> inter = new ArrayList<>(outer.get(j));
                inter.add(arr[i]);
                outer.add(inter);
            }
        }
        return outer;
    }
}
