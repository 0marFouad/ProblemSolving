package Word_Break;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size() == 0){
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<wordDict.size();i++){
            map.put(wordDict.get(i),0);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(map.get(sb.toString()) != null){
                sb = new StringBuilder();
            }
        }
        if(sb.toString().length() != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordBreak(s,wordDict);
    }
}
