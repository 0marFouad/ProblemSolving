package Leetcode.Shortest_Unsorted_Continuous_Subarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static int findUnsortedSubarray(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i< nums.length;i++){
            left[i] = Math.max(left[i-1],nums[i]);
        }
        for(int i = nums.length-2;i>=0;i--){
            right[i] = Math.min(right[i+1],nums[i]);
        }
        int l = -1;
        int r = -1;
        for(int i=0;i<left.length;i++){
            if(right[i] != nums[i] && l == -1){
                l = i;
            }
            if(left[i] != nums[i]){
                r = i;
            }
        }
        if(r == -1 || l == -1){
            return 0;
        }
        return (r - l + 1);
    }

    public static void main(String[] args){
        //int[] nums = {2,6,4,8,10,9,15};
        //System.out.print(findUnsortedSubarray(nums));
        int[] sorted = {1,2,4,5,6,7,10};
        System.out.print(Arrays.binarySearch(sorted,11));
    }

}
