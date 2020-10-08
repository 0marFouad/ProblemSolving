package Leetcode.Word_Break;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static boolean wordOpt(String s, HashSet<String> words){
        if(s.length() == 0){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(words.contains(sb.toString())){
                if(wordOpt(s.substring(i+1),words)){
                    return true;
                }
                if(s.substring(i+1).length() == 0){
                    sb = new StringBuilder();
                }
            }
        }
        return sb.toString().length() == 0;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0){
            return false;
        }
        HashSet<String> words = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            words.add(wordDict.get(i));
        }
        return wordOpt(s,words);
    }

    public static void main(String[] args){
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaa");
        wordDict.add("aaaa");
        System.out.print(wordBreak(s,wordDict));
    }
}
