package Leetcode.MinimumNumberArrowsBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        int ans = 0;
        int r;
        if(points.length == 1){
            return 1;
        }
        for(int i=0;i<points.length;i++){
            r = points[i][1];
            while(i+1<points.length && points[i+1][0] <= r){
                i++;
            }
            ans++;
        }
        return ans;
    }


    public static void main(String[] args){
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(points));
    }
}
