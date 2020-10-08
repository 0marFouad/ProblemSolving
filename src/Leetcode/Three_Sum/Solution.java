package Leetcode.Three_Sum;

import java.util.*;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        HashMap<List<Integer>,Integer> vis = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int first = nums[i];
                int second = nums[j];
                int third = - first - second;

                if(map.get(third) != null && map.get(third) > j){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(first);
                    ans.add(second);
                    ans.add(third);
                    Collections.sort(ans);
                    if(vis.get(ans) == null){
                        result.add(ans);
                        vis.put(ans,1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println("Omar");
        int[] input = {0,0,0};
        threeSum(input);
    }
}
