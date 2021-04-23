package Leetcode.Wiggle_Sort_II;

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

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums,1 + ((n)/2));
        int posOfLarge = 1;
        int posOfSmall = n-1;
        if(n%2 == 0){
            posOfSmall--;
        }

        for(int i=1;i<n;i+=2){
            if(nums[i] > median){
                swap(nums, posOfLarge,i);
                posOfLarge+=2;
            }else if(nums[i] < median){
                swap(nums,posOfSmall,i);
                i-=2;
                posOfSmall-=2;
            }
        }

        int posOfMedian = 0;
        for(int i=0;i<n;i+=2){
            if(nums[i] > median){
                swap(nums, posOfLarge,i);
                posOfLarge+=2;
                i-=2;
            }else if(nums[i] < median){
                swap(nums,posOfSmall,i);
                posOfMedian-=2;
            }
        }

    }

    public static void main(String[] args){
        int[] nums = {1,1,2,1,2,2,1};
        wiggleSort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
