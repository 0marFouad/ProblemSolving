package Leetcode.Third_Maximum_Number;

public class Solution {
    public static int thirdMax(int[] nums) {
        Integer small = null;
        Integer mid = null;
        Integer large = null;
        for(int i=0;i<nums.length;i++){
            if (small.equals(nums[i]) || mid.equals(nums[i]) || large.equals(nums[i])) continue;
            if(large == null){
                large = nums[i];
            }else if(mid == null){
                if(nums[i] > large){
                    mid = large;
                    large = nums[i];
                }else{
                    mid = nums[i];
                }
            }else if(small == null){
                if(nums[i] < mid){
                    small = nums[i];
                }else if(nums[i] < large){
                    small = mid;
                    mid = nums[i];
                }else{
                    small = mid;
                    mid = large;
                    large = nums[i];
                }
            }else{
                if(nums[i] <= small){
                    continue;
                }else if(nums[i] <= mid){
                    small = nums[i];
                }else if(nums[i] <= large){
                    small = mid;
                    mid = nums[i];
                }else{
                    small = mid;
                    mid = large;
                    large = nums[i];
                }
            }
        }
        if(small == null){
            return large;
        }
        return small;
    }

    public static void main(String[] args){
        int[] nums = {3,2,2,1};
        System.out.println(thirdMax(nums));
    }
}
