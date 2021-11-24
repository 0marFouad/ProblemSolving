package Leetcode.Jump_Game_II;

import java.util.HashMap;

class Solution {
    public static int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        if(nums[0] >= nums.length){
            return 1;
        }
        int levlen = nums[0];
        int maxReach = nums[0];
        int curlev = 1;
        int counter = 0;
        for(int i=1;i<nums.length;i++){
            while(counter < levlen){
                maxReach = Math.max(maxReach,Math.min(i+counter+nums[i+counter],nums.length-1));
                counter++;
            }
            i += levlen-1;
            levlen = maxReach - i;
            counter = 0;
            curlev++;
        }
        return curlev - 1;
    }

    public static void main(String[] args){
        int[] arr = {2,3,0,1,4};
        System.out.println(jump(arr));
    }
}