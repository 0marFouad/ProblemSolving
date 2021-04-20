package Leetcode.Partition_Labels;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> partitionLabels(String S) {
        int[] lastIdx = new int[26];
        for(int i=0;i<26;i++){
            lastIdx[i] = -1;
        }
        for(int i=0;i<S.length();i++){
            if(lastIdx[S.charAt(i) - 'a'] == -1){
                lastIdx[S.charAt(i) - 'a'] = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=S.length()-1;i>=0;i--){
            int dest = lastIdx[S.charAt(i) - 'a'];
            int num = 0;
            int j;
            for(j=i;j>=dest;j--){
                dest = Math.min(lastIdx[S.charAt(j) - 'a'],dest);
                num++;
            }
            i=j+1;
            res.add(0,num);
        }
        return res;
    }

    public static void main(String[] args){
        List<Integer> res = partitionLabels("ababcbacadefegdehijhklij");
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i) + " ");
        }
    }
}
