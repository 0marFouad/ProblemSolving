package Leetcode.Largest_Rectangle_in_Histogram;

import java.util.Stack;

public class Solution {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] l = new int[heights.length];
        int[] r = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                l[i] = -1;
            }else{
                l[i] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                r[i] = heights.length;
            }else{
                r[i] = s.peek();
            }
            s.push(i);
        }
        int mx = 0;
        for(int i=0;i<heights.length;i++){
            mx = Math.max(mx, (r[i] - l[i] - 1)*heights[i]);
        }
        return mx;
    }

    public static void main(String[] args){
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }

}
