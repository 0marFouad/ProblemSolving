package Leetcode.Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return Integer.compare(ints[0],t1[0]);
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        int[] cur = {intervals[0][0], intervals[0][1]};
        for(int i=1;i<intervals.length;i++){
            if(cur[1] < intervals[i][0]){
                int[] r1 = {cur[0], cur[1]};
                res.add(r1);
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }else{
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        res.add(cur);
        int[][] ret = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ret[i] = res.get(i);
        }
        return ret;
    }

    public static void main(String[] args){
        int[][] intervals = {{1,3},{15,18},{8,15},{4,6}};
        int[][] merged = merge(intervals);
        for(int i=0;i<merged.length;i++){
            System.out.println(merged[i][0] + " " + merged[i][1]);
        }
    }

}
