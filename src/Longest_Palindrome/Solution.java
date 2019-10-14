package Longest_Palindrome;

import java.util.Arrays;

class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[500];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'A']++;
        }
        int result = 0;
        Arrays.sort(freq);
        boolean isUsed = false;
        for(int i=freq.length-1;i>=0;i--){
            if(freq[i]%2==1){
                if(!isUsed){
                    result += freq[i];
                    isUsed = true;
                }else{
                    result += freq[i] - 1;
                }
            }else{
                result += freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("bananas"));
    }
}