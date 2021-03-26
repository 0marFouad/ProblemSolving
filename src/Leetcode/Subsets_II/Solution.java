package Leetcode.Subsets_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void backtrack(List<List<Integer>> list,int[] nums,ArrayList<Integer> temp,int start){
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backtrack(list,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(res,nums,temp,0);
        return res;
    }

}
