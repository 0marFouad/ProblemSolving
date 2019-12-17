package Minimum_Remove_to_Make_Valid_Parentheses;

import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == '('){
                st.add(i);
            }
            if(cur == ')'){
                if(!st.empty()){
                    st.pop();
                }else{
                    hs.add(i);
                }
            }
        }
        while(!st.empty()){
            hs.add(st.peek());
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!hs.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.print(minRemoveToMakeValid("a)b(c)d"));
    }
}
