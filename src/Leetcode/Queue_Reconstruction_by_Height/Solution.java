package Leetcode.Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] != o1[0]){
                    return Integer.compare(o2[0],o1[0]);
                }else{
                    return Integer.compare(o1[1],o2[1]);
                }
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            res.add(people[i][1],people[i]);
        }
        for(int i=0;i<res.size();i++){
            people[i] = res.get(i);
        }
        return people;
    }

    public static void main(String[] args){
        int[][] p = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        p = reconstructQueue(p);
        for(int i=0;i<p.length;i++){
            System.out.println(p[i][0] + " " + p[i][1]);
        }
    }
}
