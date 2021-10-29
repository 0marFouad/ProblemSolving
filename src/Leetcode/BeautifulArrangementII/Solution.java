package Leetcode.BeautifulArrangementII;

import java.util.HashSet;

public class Solution {

    public static int[] constructArray(int n, int k) {
        int starting = n - k;
        int ending = n;
        int[] res = new int[n];
        int idx = 0;
        for(int i=1;i<starting;i++){
            res[idx] = i;
            idx++;
        }
        while(starting<ending){
            res[idx] = starting;
            idx++;
            starting++;
            res[idx] = ending;
            idx++;
            ending--;
        }
        if(starting == ending){
            res[idx] = starting;
        }
        return res;
    }

    public static void main(String[] args){
        int[] res = constructArray(3,2);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i] + " ");
        }
    }

}
