package Leetcode.Next_Permutation;

public class Solution {
    public static void nextPermutation(int[] nums) {
        int ptr = -1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                ptr = i-1;
                break;
            }
        }
        if(ptr == -1){
            for(int i=0;i<nums.length/2;i++){
                int temp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = temp;
            }
        }else{
            boolean done = false;
            for(int i=ptr+1;i<nums.length;i++){
                if(nums[i] <= nums[ptr]){
                    int y = nums[i-1];
                    nums[i-1] = nums[ptr];
                    nums[ptr] = y;
                    done = true;
                    break;
                }
            }
            if(!done){
                int i = nums.length;
                int y = nums[i-1];
                nums[i-1] = nums[ptr];
                nums[ptr] = y;
            }
            for(int i=ptr+1;i<nums.length;i++){
                int y = nums[i];
                if(nums.length-i+ptr <= i){
                    break;
                }
                nums[i] = nums[nums.length-i+ptr];
                nums[nums.length-i+ptr] = y;
            }
        }
    }

    public static void main(String[] args){
        int[] n = {1,5,1};
        nextPermutation(n);
        for(int i=0;i<n.length;i++){
            System.out.print(n[i] + " ");
        }
    }
}
