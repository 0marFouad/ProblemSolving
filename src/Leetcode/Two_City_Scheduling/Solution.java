package Leetcode.Two_City_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[][] costs_diff = new int[costs.length][3];
        for(int i=0;i<costs.length;i++){
            costs_diff[i][0] = costs[i][0] - costs[i][1];
            costs_diff[i][1] = costs[i][0];
            costs_diff[i][2] = costs[i][1];
        }

        Arrays.sort(costs_diff,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0],b[0]);
            }
        });

        int mid = costs.length/2;
        int res = 0;
        for(int i=0;i<mid;i++){
            res += costs_diff[i][1];
        }
        for(int i=mid;i<2*mid;i++){
            res += costs_diff[i][2];
        }
        return res;
    }
}