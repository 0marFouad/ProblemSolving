package Leetcode.Permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void solve(int[] nums, boolean[] map, List<Integer> temp, List<List<Integer>> solutions,int taken){
        if(taken == nums.length){
            solutions.add(new ArrayList<>(temp));
        }

        for(int i=0;i<nums.length;i++){
            if(map[nums[i] + 10]){
                continue;
            }
            map[nums[i] + 10] = true;
            temp.add(nums[i]);
            solve(nums,map,temp,solutions,taken+1);
            temp.remove(temp.size() - 1);
            map[nums[i] + 10] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, new boolean[21],new ArrayList<>(), res,0);
        return res;
    }

    public static void main(String[] args){
        List<List<Integer>> res = permute(new int[]{1,2,3});
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }


}
