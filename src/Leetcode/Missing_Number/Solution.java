package Leetcode.Missing_Number;

public class Solution {
    public static int missingNumber(int[] nums) {
        int shouldHave = ((nums.length)*(nums.length+1))/2;
        int have = 0;
        for(int i=0;i<nums.length;i++){
            have += nums[i];
        }
        return shouldHave - have;
    }


}
