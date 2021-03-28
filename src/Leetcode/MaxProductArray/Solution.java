package Leetcode.MaxProductArray;

public class Solution {
    public static int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sofar = nums[0];
        int max = sofar;
        int min = sofar;
        for(int i=1;i<nums.length;i++){
            int temp = max;
            max = Math.max(nums[i],Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i],Math.min(temp*nums[i], min*nums[i]));
            sofar = Math.max(sofar,max);
        }
        return sofar;
    }

    public static void main(String[] args){
        int[] nums = {-4,-3,-2};
        System.out.println(maxProduct(nums));
    }
}
