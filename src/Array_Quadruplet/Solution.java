package Array_Quadruplet;

import java.util.*;

class Solution {

    public static boolean isEqual(List<Integer> arr1,List<Integer> arr2){
        if(!arr1.get(0).equals(arr2.get(0))){
            return false;
        }
        if(!arr1.get(1).equals(arr2.get(1))){
            return false;
        }
        if(!arr1.get(2).equals(arr2.get(2))){
            return false;
        }
        if(!arr1.get(3).equals(arr2.get(3))){
            return false;
        }
        return true;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        HashMap<List<Integer>, Boolean> resultOccurence = new HashMap<>();
        int s = target;
        for(int i=0;i<nums.length;i++){
            if(frequencyMap.get(nums[i]) == null){
                frequencyMap.put(nums[i],1);
            }else{
                frequencyMap.put(nums[i],frequencyMap.get(nums[i]) + 1);
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                for(int k=0;k<nums.length;k++){
                    if(i != j && i != k && j != k){
                        frequencyMap.put(nums[i],frequencyMap.get(nums[i]) - 1);
                        frequencyMap.put(nums[j],frequencyMap.get(nums[j]) - 1);
                        frequencyMap.put(nums[k],frequencyMap.get(nums[k]) - 1);
                        if(frequencyMap.get(s - nums[i] - nums[k] - nums[j]) != null){
                            if(frequencyMap.get(s - nums[i] - nums[k] - nums[j]) > 0){
                                List<Integer> toInsert = new ArrayList<>();
                                int[] result1 = {nums[i], nums[j], nums[k], s-nums[i]-nums[j]-nums[k]};
                                Arrays.sort(result1);
                                toInsert.add(result1[0]);
                                toInsert.add(result1[1]);
                                toInsert.add(result1[2]);
                                toInsert.add(result1[3]);
                                if(!resultOccurence.containsKey(toInsert)){
                                    result.add(toInsert);
                                    resultOccurence.put(toInsert,true);
                                }
                            }
                        }
                        frequencyMap.put(nums[i],frequencyMap.get(nums[i]) + 1);
                        frequencyMap.put(nums[j],frequencyMap.get(nums[j]) + 1);
                        frequencyMap.put(nums[k],frequencyMap.get(nums[k]) + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485};
        int target = 1057;
        fourSum(test,target);
    }

}