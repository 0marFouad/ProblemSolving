package Leetcode.Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void solve(List<Integer> result,int cur,int n){
        if(cur > n){
            return;
        }
        result.add(cur);
        solve(result, cur*10, n);
        if(cur%10 != 9){
            solve(result, cur + 1,n);
        }
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>();
        solve(l,1,n);
        return l;
    }

    public static void main(String[] args){
        List<Integer> l = lexicalOrder(13);
        for(int i=0;i<l.size();i++){
            System.out.print(l.get(i) + " ");
        }
    }
}
