package Add_One_To_Number;

import java.util.*;

public class Solution {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        for(int i=0;i<A.size();i++) {
            if(A.get(i) == 0) {
                A.remove(i);
                i--;
            }else {
                break;
            }
        }
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i) < 9){
                int n = A.remove(i);
                A.add(i, n+1);
                return A;
            }else{
                A.remove(i);
                A.add(i,0);
            }
        }
        A.add(0,1);
        return A;
    }


    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num = plusOne(num);
        System.out.print(num.get(0)+""+num.get(1)+""+num.get(2));
    }
}
