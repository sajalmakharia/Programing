package com.pratise.dp.slidingwindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s="totmtapxyzoyml";
        String t="tat";
        int j=0,min=Integer.MAX_VALUE,start=0,end=0;

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int i=0;
        int count = map.size();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                count = map.get(ch)==0?count-1:count;

            }
            if(count>0){
                j++;
            }
            if(count==0){
                while(count==0){
                    char firstChar = s.charAt(i);
                    if(map.containsKey(firstChar))
                    {
                        map.put(firstChar,map.get(firstChar)+1);
                        if(map.get(firstChar)>0){
                            count++;
                        }
                    }
                    if(min>j-i+1){
                        min=j-i+1;
                        start=i;
                        end=j;
                    }
                    i++;
                }
                j++;
            }
        }
        System.out.println(s.substring(start,end+1));
    }
}
