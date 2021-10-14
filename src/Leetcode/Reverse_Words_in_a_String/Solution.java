package Leetcode.Reverse_Words_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> split(String s){
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(sb.toString().length() > 0){
                    l.add(sb.toString());
                }
                sb = new StringBuilder();
            }else{
                sb.append(s.charAt(i));
            }
        }
        if(sb.toString().length() > 0){
            l.add(sb.toString());
        }
        return l;
    }

    public static String reverseWords(String s) {
        List<String> l = split(s);
        StringBuilder sb = new StringBuilder();
        for(int i=l.size()-1;i>=0;i--){
            if(sb.toString().length() > 0){
                sb.append(" ");
                sb.append(l.get(i));
            }else{
                sb.append(l.get(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
          String rev = reverseWords("Let's take LeetCode contest");
          System.out.print(rev);
    }
}
