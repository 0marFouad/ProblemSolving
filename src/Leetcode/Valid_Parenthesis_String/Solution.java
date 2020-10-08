package Leetcode.Valid_Parenthesis_String;

import java.util.HashMap;

public class Solution {
    public static boolean checkValidString(String s) {
        return checkString(0, s,0, new HashMap<>());
    }

    public static boolean checkString(int idx, String str,int acc, HashMap<Integer, Boolean> mp){
        if(mp.containsKey(idx*str.length() + acc)){
            return mp.get(idx*str.length() + acc);
        }
        if(acc < 0){
            return false;
        }
        if(idx == str.length()){
            return acc == 0;
        }
        boolean ans;
        if(str.charAt(idx) == '('){
            ans = checkString(idx+1,str,acc+1,mp);
        }else if(str.charAt(idx) == ')'){
            ans = checkString(idx+1, str, acc-1,mp);
        }else{
            ans = checkString(idx+1,str,acc,mp) || checkString(idx+1,str,acc-1,mp) || checkString(idx+1,str,acc+1,mp);
        }
        mp.put(idx*str.length() + acc, ans);
        return ans;
    }

    public static void main(String[] args){
        System.out.println(checkValidString("()*)*(*)*"));
    }
}
