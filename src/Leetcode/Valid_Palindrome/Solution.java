package Leetcode.Valid_Palindrome;

public class Solution {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        s = s.toLowerCase();
        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
