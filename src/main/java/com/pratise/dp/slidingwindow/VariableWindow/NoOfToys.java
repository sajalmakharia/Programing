package com.pratise.dp.slidingwindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class NoOfToys {
    public static void main(String[] args) {
        String s="abaccab";
        int i=0,j=0,max=0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            char ch =s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()<2){
                j++;
            }else if(map.size()==2){
                max = Integer.max(max,j-i+1);
                j++;
            }else{
                while(map.size()>2){
                    char firstChar = s.charAt(i);
                    if(map.get(firstChar)>1){
                        map.put(firstChar,map.get(firstChar)-1);
                    }else {
                        map.remove(firstChar);
                    }
                    i++;
                }
                j++;
            }
        }
        System.out.println(max);
    }
}
