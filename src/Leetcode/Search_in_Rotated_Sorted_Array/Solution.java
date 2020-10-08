package Leetcode.Search_in_Rotated_Sorted_Array;

public class Solution {
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l<r-1){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[l]){
                if(nums[l] <= target && nums[mid]>=target){
                    r = mid;
                    continue;
                }
            }else{
                if(nums[l] <= target || nums[mid]>=target){
                    r = mid;
                    continue;
                }
            }

            if(nums[r] >= nums[mid]){
                if(nums[mid] <= target && nums[r]>=target){
                    l = mid;
                    continue;
                }
            }else{
                if(nums[mid] <= target || nums[r]>=target){
                    l = mid;
                    continue;
                }
            }
            return -1;
        }
        if(nums[l] == target){
            return l;
        }
        if(nums[r] == target){
            return r;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] num = {4,5,6,7,0,1,2};
        System.out.println(search(num,0));
    }
}
