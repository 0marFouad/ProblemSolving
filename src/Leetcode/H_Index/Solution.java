package Leetcode.H_Index;

import java.util.Arrays;

public class Solution {

    //nlogn
    public static int hIndexS(int[] citations) {
        Arrays.sort(citations);
        int h_index = 0;
        int n=1;
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i] >= n){
                h_index = n;
            }else{
                return h_index;
            }
            n++;
        }
        return h_index;
    }

    //n
    public static int hIndex(int[] citations) {
        int[] map = new int[citations.length+1];
        int res = 0;
        for(int i=0;i<citations.length;i++){
            map[Math.min(citations[i],citations.length)]++;
        }
        for(int i=map.length-1;i>=0;i--){
            if(res + map[i] > i){
                res = Math.max(res,i);
                return res;
            }
            res += map[i];
        }
        return res;
    }

    public static void main(String[] args){
        int[] c = {0,1,5,5,5,5,6,6};
        System.out.print(hIndex(c));
    }
}
