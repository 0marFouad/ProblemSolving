package Leetcode.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void rec(int o,int c,ArrayList<Character> cur,ArrayList<String> all){
        if(c<o){
            return;
        }
        if(o == 0 && c==0){
            String ss = "";
            for(int i=0;i<cur.size();i++){
                ss += cur.get(i);
            }
            all.add(ss);
            return;
        }
        if(o != 0){
            cur.add('(');
            rec(o-1,c,cur,all);
            cur.remove(cur.size()-1);
        }
        if(c != 0){
            cur.add(')');
            rec(o,c-1,cur,all);
            cur.remove(cur.size()-1);
        }
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> l = new ArrayList<>();
        rec(n,n,new ArrayList<>(), l);
        return l;
    }

    public static void main(String[] args){
        List<String> ans = generateParenthesis(4);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
