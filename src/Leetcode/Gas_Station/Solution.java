package Leetcode.Gas_Station;

import java.util.ArrayList;

public class Solution {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int res = 0;
        for(int i=0;i<gas.length;i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                total += sum;
                sum = 0;
                res = i+1;
            }
        }
        sum += total;
        return sum >= 0 ? res : -1;
    }

    public static void main(String[] args){
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas,cost));
    }

}
