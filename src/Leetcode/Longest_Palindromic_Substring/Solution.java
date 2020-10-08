package Leetcode.Longest_Palindromic_Substring;

public class Solution {

    public static String longestPalindrome(String s) {
        boolean[][] grid = new boolean[s.length()][s.length()];
        if(s.equals("")){
            return s;
        }
        String result = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            grid[i][i] = true;
        }

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                grid[i][i+1] = true;
                result = s.substring(i,i+2);
            }
        }

        for(int k=3;k<=s.length();k++){
            for(int i=0;i<s.length()-k+1;i++){
                int j = i + k - 1;
                if(grid[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    grid[i][j] = true;
                    if(k > result.length()){
                        result = s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("ccc"));
    }

}
