package com.pratise.dp.recursion;


import java.util.*;

// a string is given a dictonary .In case all the word in the string are present
// in the dict then print the o/p in list else blank
public class WordBreak {
    Map<String, List<String>> mem = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        List<String> result = new ArrayList<>();
        for(String word:wordDict){
            if(!s.startsWith(word)){
                continue;
            }
            if(s.length()==word.length())
            {
                result.add(word);
                continue;
            }
            List<String> wordList = wordBreak(s.substring(word.length()),wordDict);
            for(String wordR: wordList){
                StringBuilder sb = new StringBuilder();
                sb.append(word).append(" ").append(wordR);
                result.add(sb.toString());
            }
        }

        mem.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] ws = {"cats","and","dog"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(ws));
        WordBreak wb= new WordBreak();
        System.out.println(wb.wordBreak(s,wordDict));
    }
}
