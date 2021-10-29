package Leetcode.BoatsSavePeople;

import java.util.Arrays;

public class Solution {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length - 1;
        while(l<r){
            if(people[l] + people[r] <= limit){
                ans++;
                l++;
                r--;
            }else if(people[r] <= limit){
                ans++;
                r--;
            }
        }
        if(l == r){
            return ans + 1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] people = {3,3,4,5};
        int limit = 5;
        System.out.println(numRescueBoats(people,limit));
    }
}
