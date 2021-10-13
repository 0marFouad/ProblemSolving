package Leetcode.Three_Sum;

import java.util.*;

public class Solution {


    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length - 1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    solutions.add(res);
                    j++;
                    while(j<nums.length && nums[j] == nums[j-1]){
                        j++;
                    }
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return solutions;
    }


    public static void main(String[] args){
        System.out.println("Omar");
        int[] input = {-2,0,1,1,2};
        List<List<Integer>> res = threeSum(input);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i).get(0) + " ");
            System.out.print(res.get(i).get(1) + " ");
            System.out.print(res.get(i).get(2) + "\n");
        }
    }
}
