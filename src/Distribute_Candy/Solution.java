package Distribute_Candy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int candy(ArrayList<Integer> A) {
        int n=A.size();
        int[] candies=new int[n];
        Arrays.fill(candies,1);
        for(int i=0;i<n-1;i++){
            if(A.get(i+1)>A.get(i))
                candies[i+1]=candies[i]+1;
        }
        for(int i=n-1;i>0;i--){
            if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
                candies[i-1]=candies[i]+1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=candies[i];
        }
        return sum;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-1);
        a.add(3); //1
        a.add(6);
        a.add(6);
        a.add(6); //2
        a.add(7); //1
        a.add(1); //1
        System.out.println(candy(a));
    }
}
