package Leetcode.Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static boolean isEqual(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = p.length() - 1;
        int[] pArr = new int[26];
        int[] tArr = new int[26];
        for(int i=0;i<p.length();i++){
            pArr[p.charAt(i) - 'a']++;
        }
        for(int i=ptr1;i<ptr2;i++){
            tArr[s.charAt(i) - 'a']++;
        }
        do{
            tArr[s.charAt(ptr2) - 'a']++;
            if(isEqual(pArr,tArr)){
                result.add(ptr1);
            }
            tArr[s.charAt(ptr1) - 'a']--;
            ptr1++;
            ptr2++;
        }while(ptr2<s.length());
        return result;
    }

    public static void main(String[] args){
        List<Integer> res = findAnagrams("abab","ab");
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i) + " ");
        }
    }
}
