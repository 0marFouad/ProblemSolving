package Leetcode.Palindromic_Substrings;

public class Solution {
    public static int countSubstrings(String s) {
        int n = s.length();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            arr[i][i] = 1;
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                arr[i][i+1] = 1;
            }
        }

        for(int gap=2;gap<n;gap++){
            for(int i=0;i<n-gap;i++){
                int j = i+gap;
                if(s.charAt(i) == s.charAt(j) && arr[i+1][j-1] == 1){
                    arr[i][j] = 1;
                }
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res += arr[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(countSubstrings("abc"));
    }
}
