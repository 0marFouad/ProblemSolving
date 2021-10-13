package Leetcode.RotateArray;

public class solution {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        int j = nums.length - k - 1;
        int l = j+1;
        int m = nums.length - 1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        while(l<m){
            int temp = nums[l];
            nums[l] = nums[m];
            nums[m] = temp;
            l++;
            m--;
        }
        i=0;
        j=nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        int[] nums = {-1,-100,3,99};
        rotate(nums,2);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
