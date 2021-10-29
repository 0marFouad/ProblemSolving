package Leetcode.Longest_Palindromic_Substring;

public class Solution {

    public static String longestPalindrome(String s) {
        boolean[][] grid = new boolean[s.length()][s.length()];
        int max = 0;
        int startRes = -1;
        for(int i=0;i<s.length();i++){
            grid[i][i] = true;
            if(max < 1){
                max = 1;
                startRes = i;
            }
        }

        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                grid[i-1][i] = true;
                if(max < 2){
                    max = 2;
                    startRes = i-1;
                }
            }
        }

        int gap = 2;
        for(int i=gap;i<s.length();i++){
            for(int j=0;j+i<s.length();j++){
                if(grid[j+1][j+i-1] && s.charAt(j) == s.charAt(j+i)){
                    grid[j][j+i] = true;
                    if(max < i+1){
                        max = i+1;
                        startRes = j;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=startRes;i<startRes+max;i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("aaaa"));
    }

}
