package Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i='a';i<='z';i++){
            map.put(i,0);
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right != s.length()){
            map.put(s.charAt(right),map.get(s.charAt(right))+1);
            while(map.get(s.charAt(right)) > 1){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
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
