package Word_Break_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static List<String> wordBreakOpt(String s, HashSet<String> words) {
        List<String> result = new ArrayList<>();
        String cur = "";
        for(int i=0;i<s.length();i++){
            cur += s.charAt(i);
            if(words.contains(cur)){
                List<String> complete = wordBreakOpt(s.substring(i+1), words);
                for(int j=0;j<complete.size();j++){
                    result.add(cur+" "+complete.get(j));
                }
                if(i == s.length()-1){
                    result.add(cur);
                }
            }
        }
        return result;
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        if(s.length()==0){
            List<String> res = new ArrayList<>();
            return res;
        }
        HashSet<String> words = new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            words.add(wordDict.get(i));
        }
        return wordBreakOpt(s,words);

    }

    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        List<String> res = wordBreak("catsanddog", wordDict);
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i)+" ");
        }
    }
}
