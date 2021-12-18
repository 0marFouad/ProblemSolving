package Leetcode.First_Missing_Positive;

public class Solution {
    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 1 || nums[i] > nums.length){
                nums[i] = nums.length + 1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i]) != nums.length + 1){
                int position = Math.abs(nums[i]) - 1;
                nums[position] = nums[position] > 0 ? -nums[position] : nums[position];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args){
        int[] A = {1,2,3,4};
        System.out.println(firstMissingPositive(A));
    }
}
