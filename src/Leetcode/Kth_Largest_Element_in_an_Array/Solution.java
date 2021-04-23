package Leetcode.Kth_Largest_Element_in_an_Array;

public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        k = nums.length - k;
        while(l <= r){
            int pivot = nums[r];
            int emptySlot = l;
            for(int i=l;i<r;i++){
                if(nums[i] <= pivot){
                    int temp = nums[emptySlot];
                    nums[emptySlot] = nums[i];
                    nums[i] = temp;
                    emptySlot++;
                }
            }
            int temp = nums[emptySlot];
            nums[emptySlot] = nums[r];
            nums[r] = temp;
            if(k == emptySlot){
                return nums[emptySlot];
            }else if(k < emptySlot){
                r = emptySlot - 1;
            }else{
                l = emptySlot + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }
}
