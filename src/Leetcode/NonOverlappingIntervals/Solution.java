package Leetcode.NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        int ans = 0;
        if(intervals.length == 0){
            return 0;
        }
        int last = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < last){
                ans++;
            }else{
                last = intervals[i][1];
            }
        }
        return ans;
    }
}
