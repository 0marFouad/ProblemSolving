package Leetcode.Binary_Search;

public class solution {
    public static int search(int[] nums,int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            }else if (nums[mid] > target) {
                j = mid;
            }else{
                return mid;
            }
        }
        if(nums[i] < target){
            return i+1;
        }
        return i;
    }



    public static void main(String[] args){
        int[] nums = {1,3};
        System.out.print(search(nums,1));
    }
}
