package Leetcode.Decode_String;

public class Solution {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() == 0){
            return "";
        }
        boolean test_bracket = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '[' || s.charAt(i) == ']'){
                test_bracket = true;
            }
        }
        if(!test_bracket){
            return s;
        }
        while(s.length() > 0 && s.charAt(0) >= 'a' && s.charAt(0) <= 'z'){
            sb.append(s.charAt(0));
            s = s.substring(1);
        }
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z'){
            return s;
        }
        int idx = 0;
        String num = "";
        String bracket = "";
        while(s.charAt(idx) != '['){
            num += s.charAt(idx);
            idx++;
        }
        int cnt = 0;
        while((s.charAt(idx) != ']' || cnt != 1) && idx < s.length()){
            char cur = s.charAt(idx);
            if(cur == '['){
                cnt++;
            }else if(cur == ']'){
                cnt--;
            }
            bracket += cur;
            idx++;
        }
        bracket = bracket.substring(1);
        String temp = decodeString(bracket);
        for(int i=0;i<Integer.parseInt(num);i++){
            sb.append(temp);
        }
        sb.append(decodeString(s.substring(idx+1)));
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(decodeString("3[a]2[c]"));
    }
}
