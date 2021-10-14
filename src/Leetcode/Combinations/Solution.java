package Leetcode.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void solve(int n, int k, List<List<Integer>> solution,List<Integer> temp,int idx){
        if(k == 0){
            solution.add(new ArrayList<>(temp));
            return;
        }
        if(idx == n+1){
            return;
        }
        solve(n,k,solution,temp,idx+1);
        temp.add(idx);
        solve(n,k-1,solution,temp,idx+1);
        temp.remove(temp.size()-1);
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(n,k,res,temp,1);
        return res;
    }

    public static void main(String[] args){
        List<List<Integer>> res = combine(3,2);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
