package Leetcode.Container_With_Most_Water;

public class Solution {

    public static int calArea(int left,int right,int[] height){
        return Math.min(height[left],height[right])*(right - left);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int currentArea = calArea(left,right,height);
        while(left < right){
            int keepLeft = calArea(left,right-1,height);
            int keepRight = calArea(left+1,right,height);
            if(height[left] > height[right]){
                currentArea = Math.max(currentArea,keepLeft);
                right--;
            }else{
                currentArea = Math.max(currentArea,keepRight);
                left++;
            }
        }
        return currentArea;
    }

    public static void main(String[] args){
        int[] input = {1,3,2,5,25,24,5};
        System.out.println(maxArea(input));
    }
}
