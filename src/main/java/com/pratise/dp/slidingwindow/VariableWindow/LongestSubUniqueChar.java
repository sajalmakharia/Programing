package com.pratise.dp.slidingwindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubUniqueChar {
    public static void main(String[] args) {
        String s = "aabacbecfd";
      //  System.out.println(longSubKUnique(s,s.length(),3));
        int i=0,j=0;
        int maxLength=0;
        String curSub="";
        String maxSub="";
        while(j<s.length()){
            if(!curSub.contains(""+s.charAt(j))) {
                curSub += s.charAt(j);
                j++;
            } else if(curSub.contains(""+s.charAt(j)) && curSub.charAt(0)== s.charAt(i)){
                if(maxLength<curSub.length()){
                    maxLength=curSub.length();
                    maxSub=curSub;
                }
                curSub = curSub.substring(1);
                curSub +=s.charAt(j);
                i++;
                j++;
            }
            if(maxLength<curSub.length()){
                maxLength=curSub.length();
                maxSub=curSub;
            }

        }
        System.out.println(maxLength);
        System.out.println(maxSub);
    }

    public static int longSubKUnique(String s, int n,int k){
        int i=0,j=0,subLength=0,unique=0;
        Map<Character,Integer> charMap = new HashMap<>();
        while(j<n){
            char ch = s.charAt(j);
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
            if(charMap.size()<k){
                j++;
            }
            else if(charMap.size() ==k){
                subLength = Integer.max(subLength,j-i+1);
                j++;
            } else {
                while(charMap.size()>k){
                    char firstChar = s.charAt(i);
                    if(charMap.get(firstChar)>1){
                        charMap.put(firstChar,charMap.get(firstChar)-1);
                    }else {
                        charMap.remove(firstChar);
                    }
                    i++;
                }

                j++;
            }
        }
        return subLength;
    }
}
