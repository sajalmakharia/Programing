package com.pratise.dp.slidingwindow.fixedWindow;

import java.util.HashMap;
import java.util.Map;

public class AnagramOccuranceCount {
    public static void main(String[] args) {

        String text ="forxxorfxaofr";
        String pattern="for";
        int ans=0,count;
        int pn=pattern.length();
        int sn=text.length();
        Map<Character,Integer> charMap = new HashMap<>();
        for(int i=0;i<pn;i++){
            char ch = pattern.charAt(i);
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        }
        count=charMap.size();
        int i=0,j=0;
        while(j<sn){
            char ch = text.charAt(j);
            if(charMap.containsKey(ch)){
                charMap.put(ch,charMap.get(ch)-1);
                if(charMap.get(ch)==0){
                    count--;
                }
            }
            if(j-i+1<pn){
                j++;
            }else if(j-i+1==pn){
                if(count==0){
                    ans++;
                }
                char firstChar = text.charAt(i);
                if(charMap.containsKey(firstChar)){
                    charMap.put(firstChar,charMap.get(firstChar)+1);
                    if(charMap.get(firstChar)==1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        System.out.println(ans);
    }
}
