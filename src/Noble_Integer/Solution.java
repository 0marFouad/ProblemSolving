package Noble_Integer;
import java.util.*;

public class Solution {
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i) == A.size()-1-i){
                if(A.get(i)!=0){
                    if(A.get(i+1)!=A.get(i)){
                        return 1;
                    }
                }else{
                    return 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-6);
        A.add(-4);
        A.add(-2);
        A.add(-1);
        A.add(0);
        System.out.print(solve(A));
    }
}
