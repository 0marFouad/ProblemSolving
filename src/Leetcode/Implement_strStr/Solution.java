package Leetcode.Implement_strStr;

public class Solution {
    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        int crnt = 0;
        for(int i=0;i<haystack.length();i++){
            for(int j=0;j<needle.length();j++){
                if(i+j < haystack.length() && haystack.charAt(i+j) == needle.charAt(j)){
                    crnt++;
                }else{
                    break;
                }
            }
            if(crnt == needle.length()){
                return i;
            }
            crnt = 0;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(strStr("mississippi","issip"));
    }
}


