package Contiguous_Array;

class Solution {
    public static int findMaxLength(int[] nums) {
        int mx=0;
        int[] data = new int[2];
        for(int i=0;i<nums.length;i++){
            data[0] = data[1] = 0;
            for(int j=i;j<nums.length;j++){
                data[nums[j]]++;
                if(data[0] == data[1]){
                    mx = Math.max(mx,j-i+1);
                }
            }
        }
        return mx;
    }
}