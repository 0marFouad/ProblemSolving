package Leetcode.Longest_Common_Prefix;


public class Solution {

    public static String prefixOf2Strings(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i) == s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs){
        String fixed = new String(strs[0]);
        for(int i=0;i<strs.length;i++){
            fixed = prefixOf2Strings(fixed, strs[i]);
        }
        return fixed;
    }


    public static void main(String[] args){
        String[] input = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input));
    }
}
