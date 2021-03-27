package Leetcode.Sort_Colors;

public class Solution {
    //2 pass
    public static void sortColors2(int[] nums) {
        int[] count = {0,0,0};
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for(int i=0;i<nums.length;i++){
            if(count[0]>0){
                nums[i] = 0;
                count[0]--;
            }else if(count[1]>0){
                nums[i] = 1;
                count[1]--;
            }else{
                nums[i] = 2;
                count[2]--;
            }
        }
    }

    //1 pass
    public static void sortColors(int[] nums) {
        int idx0 = 0;
        int idx2 = nums.length-1;
        for(int i=0;i<nums.length&&i<=idx2;i++){
            if(nums[i] == 0){
                int temp = nums[idx0];
                nums[i] = temp;
                nums[idx0] = 0;
                idx0++;
            }else if(nums[i] == 2){
                int temp = nums[idx2];
                nums[i] = temp;
                nums[idx2] = 2;
                idx2--;
                i--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
}
