package Leetcode.Remove_Element;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int countOfVal = 0;
        int putHere = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                countOfVal++;
            }else{
                nums[putHere] = nums[i];
                putHere++;
            }
        }
        return nums.length - countOfVal;
    }

    public static void main(String[] args){
        System.out.println("Omar");
    }
}
