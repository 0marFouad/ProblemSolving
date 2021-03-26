package Leetcode.Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionCompleteSearch {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,res,new ArrayList<>(),target,0);
        return res;
    }

    public static void backtrack(int[] candidates,List<List<Integer>> list,ArrayList<Integer> temp,int current,int start){
        if(current < 0){
            return;
        }else if(current == 0){
            list.add(new ArrayList<>(temp));
        }else{
            for(int i=start;i<candidates.length;i++){
                temp.add(candidates[i]);
                backtrack(candidates,list,temp,current - candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        for(int i=1;i<=20;i++){
            List<List<Integer>> res = combinationSum(nums,i);
            System.out.println(i + " " + res.size());
        }
    }

    //T(n) = mT(n-1) + m; --> m^n
    //m is length of array
    //n is target
    //we have distinct numbers so it will be m^(sqrt(n))
    // n-1-2-3-4... not n-1-1-1-1

}
