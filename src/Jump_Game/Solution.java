package Jump_Game;

public class Solution {
    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int num = 1;
        boolean reach = true;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] >= num){
                reach = true;
                num = 1;
            }else{
                reach = false;
                num++;
            }
        }
        return reach;
    }

    public static void main(String[] args){
        int[] tst = {3,2,1,0,4};
        System.out.println(canJump(tst));
    }
}
