package Leetcode.SquareOfSortedArray;

public class solution {

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int cur = result.length - 1;
        int i = 0;
        int j = nums.length - 1;
        while(i<=j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[cur] = (nums[i]*nums[i]);
                i++;
            }else{
                result[cur] = (nums[j]*nums[j]);
                j--;
            }
            cur--;
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {-4,-1,0,3,10};
        int[] res = sortedSquares(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

}
