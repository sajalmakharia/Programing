package com.pratise.dp.slidingwindow.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombPhoneNum {
    public static void main(String[] args) {
        /*Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jhl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        int[] a = {2,3,7};
        List<String> wordList = letterCombination(map,a,a.length,"",0);
        System.out.println(wordList);*/
      //  phonePad("","12");
        System.out.println(phonePadCount("","347"));

    }

    private static List<String> letterCombination(Map<Integer, String> map, int[] a, int length, String s, int index) {
        if(length==index){
            List<String> word = new ArrayList<>();
            word.add(s);
            return word;
        }
        String numLetters = map.get(a[index]);
        List<String> wordList = new ArrayList<>();
        for(int i=0;i<numLetters.length();i++){
            String copyWord = s;
            copyWord = copyWord+numLetters.charAt(i);
            wordList.addAll(letterCombination(map,a,length,copyWord,index+1));
        }

        return wordList;
    }

    static void phonePad(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char d = (char)('a'+i);
            phonePad(p+d,up.substring(1));

        }
    }
    static int phonePadCount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char d = (char)('a'+i);
            count = count+phonePadCount(p+d,up.substring(1));
        }
        return count;
    }

}
