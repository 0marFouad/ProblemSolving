package Leetcode._123Pattern;

import java.util.Stack;

public class Solution {

    public static boolean find132pattern(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];

        for(int i=1;i<left.length;i++){
            left[i] = Math.min(left[i-1],nums[i]);
        }

        Stack<Integer> s = new Stack<>();

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] > left[i]){
                while(!s.isEmpty() && s.peek() <= left[i]){
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() < nums[i]){
                    return true;
                }
                s.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {3,1,4,2};
        System.out.print(find132pattern(nums));
    }

}
