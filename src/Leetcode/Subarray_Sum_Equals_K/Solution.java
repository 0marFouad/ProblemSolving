package Leetcode.Subarray_Sum_Equals_K;

import java.util.HashMap;

class Solution {
    public static int subarraySum(int[] nums, int k) {
        int[] acc = new int[nums.length];
        int a = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            a += nums[i];
            acc[i] = a;
            mp.put(acc[i], mp.getOrDefault(acc[i], 0) + 1);
            int x = acc[i];
            int look_for = x - k;
            ans += mp.getOrDefault(look_for, 0);
            if(look_for == 0){
                ans++;
            }
            if(x == look_for){
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {1,1,1}; // -1 -2 -1
        System.out.println(subarraySum(arr,2));
    }
}
