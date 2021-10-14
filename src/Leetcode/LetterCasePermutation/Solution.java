package Leetcode.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void solve(String s, int idx,StringBuilder temp, List<String> solution){
        if(idx == s.length()){
            solution.add(new StringBuilder(temp.toString()).toString());
            return;
        }
        if((s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') || (s.charAt(idx) >= 'A' && s.charAt(idx) <= 'Z')){
            temp.append(Character.toUpperCase(s.charAt(idx)));
            solve(s,idx+1,temp,solution);
            temp.deleteCharAt(temp.length()-1);
            temp.append(Character.toLowerCase(s.charAt(idx)));
            solve(s,idx+1,temp,solution);
            temp.deleteCharAt(temp.length()-1);
        }else{
            temp.append(s.charAt(idx));
            solve(s,idx+1,temp,solution);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        solve(s,0,tmp,res);
        return res;
    }

    public static void main(String[] args){
        String s = "a2z";
        List<String> l = letterCasePermutation(s);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
