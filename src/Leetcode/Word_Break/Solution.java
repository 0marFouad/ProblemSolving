package Leetcode.Word_Break;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static boolean wordOpt(String s, HashSet<String> words, HashMap<String, Boolean> vis){
        if(vis.get(s) != null){
            return vis.get(s);
        }
        if(s.length() == 0){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(words.contains(sb.toString())){
                if(wordOpt(s.substring(i+1),words,vis) || s.substring(i+1).length() == 0){
                    return true;
                }
            }
        }
        vis.put(s,sb.toString().length() == 0);
        return false;
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        if(s.length()==0){
            return false;
        }
        HashSet<String> words = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            words.add(wordDict.get(i));
        }
        HashMap<String, Boolean> vis = new HashMap<>();
        return wordOpt(s,words,vis);
    }


    public static boolean wordBreak(String s, List<String> wordDict){
        if(s.length()==0){
            return false;
        }
        HashSet<String> words = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            words.add(wordDict.get(i));
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i=1;i<= s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && words.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        String s = "abcdef";
        System.out.println(s.substring(1,2));
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaa");
        wordDict.add("aaaa");
        System.out.print(wordBreak(s,wordDict));
    }
}
