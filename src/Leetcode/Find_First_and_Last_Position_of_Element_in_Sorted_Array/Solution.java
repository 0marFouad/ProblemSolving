package Leetcode.Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {

    public static int search(int[] nums,int target,boolean left){
        int l = 0;
        int h = nums.length-1;
        while(l < h-1){
            int mid = (l+h)/2;
            if(nums[mid] > target){
                h = mid-1;
            }
            if(nums[mid] < target){
                l = mid+1;
            }
            if(nums[mid] == target){
                if(left){
                    h = mid;
                }else{
                    l = mid;
                }
            }
        }
        if(l != h){
            if(nums[l] == nums[h]){
                if(left){
                    return l;
                }else {
                    return h;
                }
            }else{
                if(nums[l] == target){
                    return l;
                }else{
                    return h;
                }
            }
        }
        return l;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length == 0){
            return res;
        }
        int left = search(nums,target,true);
        if(nums[left] != target){
            return res;
        }
        int right = search(nums,target,false);
        res[0] = left;
        res[1] = right;
        return res;
    }

    public static void main(String[] args){
        int[] nums = {6};
        System.out.print(searchRange(nums,8)[0]+" "+searchRange(nums,8)[1]);
    }

}
