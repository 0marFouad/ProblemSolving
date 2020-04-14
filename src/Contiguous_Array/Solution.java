package Contiguous_Array;

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] arr = new int[nums.length];
        int cur = 0;
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<arr.length;i++){
            if(nums[i] == 1){
                cur++;
            }else{
                cur--;
            }
            arr[i] = cur;
            if(mp.containsKey(cur)){
                ans = Math.max(ans,i-mp.get(cur));
            }else{
                mp.put(cur,i);
            }
        }
        return ans;
    }
}