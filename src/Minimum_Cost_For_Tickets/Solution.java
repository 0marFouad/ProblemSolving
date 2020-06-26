package Minimum_Cost_For_Tickets;

import java.util.Arrays;

public class Solution {
    //Edit Commit Msg
    public static int mincostTickets(int[] days, int[] costs) {
        Arrays.sort(days);
        int[] map = new int[days[days.length-1] + 1];
        map[0] = -1;
        int ptr = 1;
        for(int i=0;i<days.length;i++){
            while(ptr < days[i]){
                map[ptr] = map[ptr-1];
                ptr++;
            }
            map[ptr] = map[ptr-1] + 1;
            ptr++;
        }
        int[] dp = new int[days.length];
        dp[0] = Math.min(costs[0], Math.min(costs[1],costs[2]));
        for(int i=1;i<dp.length;i++){
            int today = map[days[i]];
            int prevDay = map[Math.max(0,days[i] - 1)];
            int prevWeek = map[Math.max(0,days[i] - 7)];
            int prevMonth = map[Math.max(0,days[i] - 30)];
            if(prevDay >= 0){
                dp[today] = dp[prevDay] + costs[0];
            }
            if(prevWeek >= 0){
                dp[today] = Math.min(dp[today],dp[prevWeek] + costs[1]);
            }else{
                dp[today] = Math.min(dp[today],costs[1]);
            }
            if(prevMonth >= 0){
                dp[today] = Math.min(dp[today], dp[prevMonth] + costs[2]);
            }else{
                dp[today] = Math.min(dp[today],costs[2]);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int[] days = {1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29};
        int[] costs = {3,14,50};
        System.out.println(mincostTickets(days,costs));
    }
}
