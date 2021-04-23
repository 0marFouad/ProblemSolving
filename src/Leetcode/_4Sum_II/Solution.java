package Leetcode._4Sum_II;

import java.util.HashMap;

public class Solution {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[] arr = new int[nums1.length * nums2.length];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                arr[i*nums1.length + j] = nums1[i]+nums2[j];
                hm.put(nums3[i] + nums4[j],hm.getOrDefault(nums3[i] + nums4[j],0) + 1);
            }
        }
        int res = 0;
        for(int i=0;i<arr.length;i++){
            res += hm.getOrDefault(-arr[i],0);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums1 = {-1,-1};
        int[] nums2 = {-1,1};
        int[] nums3 = {-1,1};
        int[] nums4 = {1,-1};
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                for(int k=0;k<nums3.length;k++){
                    for(int l=0;l<nums4.length;l++){
                        if(nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0){
                            System.out.println(i + " " + j + " " + k + " " + l);
                        }
                    }
                }
            }
        }
        System.out.print(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
