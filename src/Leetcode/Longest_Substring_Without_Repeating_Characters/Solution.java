package Leetcode.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right != s.length()){
            map[s.charAt(right) - ' ']++;
            while(map[s.charAt(right) - ' '] > 1){
                map[s.charAt(left) - ' ']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
