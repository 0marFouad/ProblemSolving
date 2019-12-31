package Trapping_Rain_Water;

class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int mx = 0;
        for(int i=0;i<height.length;i++){
            left[i] = mx;
            mx = Math.max(mx,height[i]);
        }
        mx = 0;
        for(int i=height.length-1;i>=0;i--){
            right[i] = mx;
            mx = Math.max(mx,height[i]);
        }
        int v = 0;
        for(int i=0;i<height.length;i++){
            if(left[i] > height[i] && right[i] > height[i]){
                v += Math.min(left[i],right[i]) - height[i];
            }
        }
        return v;
    }
}