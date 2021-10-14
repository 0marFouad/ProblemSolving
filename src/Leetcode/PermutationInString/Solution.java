package Leetcode.PermutationInString;

public class Solution {

    public static boolean isEqual(int[] a1,int[] a2){
        for(int i=0;i<a1.length;i++){
            if(a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] arr1 = new int[26];
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i) - 'a']++;
        }

        int[] slidingArr = new int[26];
        for(int i=0;i<s1.length();i++){
            slidingArr[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = s1.length() - 1;

        while(r < s2.length()-1){
            if(isEqual(arr1,slidingArr)){
                return true;
            }
            slidingArr[s2.charAt(l) - 'a']--;
            slidingArr[s2.charAt(r+1) - 'a']++;
            l++;
            r++;
        }
        if(isEqual(arr1,slidingArr)){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        String s1 = "a";
        String s2 = "ab";

        System.out.println(checkInclusion(s1,s2));
    }
}
