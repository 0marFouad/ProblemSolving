package Leetcode.Majority_Element;

public class Solution {
    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(count == 0){
                major = nums[i];
                count++;
            }else if(major == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1,3,1,1,4,1,1,5,1,1,6};
        System.out.println(majorityElement(nums));
    }
}
