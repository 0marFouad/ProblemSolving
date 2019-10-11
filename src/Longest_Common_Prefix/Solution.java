package Longest_Common_Prefix;

import java.util.HashMap;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder result = new StringBuilder("");
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i='a';i<='z';i++){
            map.put(i,0);
        }
        int minLenght = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLenght = Math.min(minLenght,strs[i].length());
        }
        for(int j=0;j<minLenght;j++){
            for(int i=0;i<strs.length;i++){
                if(map.get(strs[i].charAt(j)) != null){
                    map.put(strs[i].charAt(j),map.get(strs[i].charAt(j))+1);
                }else{
                    map.put(strs[i].charAt(j),1);
                }
            }
            if(map.get(strs[0].charAt(j)) % strs.length == 0) {
                result.append(strs[0].charAt(j));
            }else{
                return result.toString();
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String[] input = {"aa","aa","aa"};
        System.out.println(longestCommonPrefix(input));
    }
}
