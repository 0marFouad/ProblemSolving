package Leetcode.Find_the_Duplicate_Number;

public class Solution {
    public static int getIdx(int n){
        return Math.abs(n) - 1;
    }

    public static int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int idx = getIdx(num);
            if(nums[idx] < 0){
                return Math.abs(num);
            }else{
                nums[idx] = -nums[idx];
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {3,1,3,4,2};
        System.out.print(findDuplicate(nums));
    }
}
