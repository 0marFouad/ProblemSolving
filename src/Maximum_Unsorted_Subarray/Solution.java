package Maximum_Unsorted_Subarray;
import java.util.*;
public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        left[0] = A.get(0);
        for(int i=1;i<A.size();i++){
            left[i] = Math.max(left[i-1],A.get(i));
        }
        right[A.size()-1] = A.get(A.size()-1);
        for(int i=A.size()-2;i>=0;i--){
            right[i] = Math.min(right[i+1],A.get(i));
        }

        int start = 0,end = A.size()-1;
        while(start<A.size() && right[start] == A.get(start)){
            start++;
        }
        while(end>=0 && left[end] == A.get(end)){
            end--;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(start<=end){
            ans.add(start);
            ans.add(end);
        }else{
            ans.add(-1);
        }
        return ans;
    }
}
