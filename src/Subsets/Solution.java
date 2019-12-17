package Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> getSubset(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        int i=0;
        while(k!=0){
            if(k%2==1){
                res.add(nums[i]);
            }
            i++;
            k = k>>1;
        }
        return res;
    }


    public List<List<Integer>> subsets(int[] nums) {
        double x = Math.pow(2,nums.length);
        List<List<Integer>> rs = new ArrayList<>();
        if(nums.length == 0){
            return rs;
        }
        for(int i=0;i<x;i++){
            rs.add(getSubset(nums,i));
        }
        return rs;
    }
}