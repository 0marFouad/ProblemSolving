package Leetcode.H_Index_II;

public class Solution {
    public static int hIndex(int[] citations) {
        if( citations.length == 0 || citations[citations.length-1] == 0){
            return 0;
        }
        int l = 0;
        int r = citations.length - 1;
        while(r>l+1){
            int mid = (l+r)/2;
            int shouldbe = citations.length - mid;
            if(citations[mid] >= shouldbe){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(citations[l] >= citations.length - l){
            return citations.length - l;
        }
        return citations.length - r;
    }

    public static void main(String[] args){
        int[] citations = {11,15};
        System.out.println(hIndex(citations));
    }
}
