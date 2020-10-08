package Leetcode.Two_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] result = {-1,-1};
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) == null){
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(nums[i],newList);
            }else{
                map.get(nums[i]).add(i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(target == 2*nums[i]){
                if(map.get(target - nums[i]) != null && map.get(target - nums[i]).size() > 1){
                    if(map.get(target - nums[i]).get(0) == i){
                        result[0] = i;
                        result[1] = map.get(target - nums[i]).get(1);
                    }
                }
            }else{
                if(map.get(target - nums[i]) != null){
                    result[0] = i;
                    result[1] = map.get(target - nums[i]).get(0);
                }
            }
        }
        Arrays.sort(result);
        return result;
    }

}
