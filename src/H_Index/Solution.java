package H_Index;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int hIndex(int[] citations) {
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

    public static void main(String[] args){
        int[] c = {3,0,6,1,5};
        System.out.print(hIndex(c));
    }
}
