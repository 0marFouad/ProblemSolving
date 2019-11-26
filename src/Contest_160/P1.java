package Contest_160;

import java.util.ArrayList;
import java.util.List;

public class P1 {


    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> work = new ArrayList<>();
        work.add(0);
        work.add(1);
        int nn = n;
        int cons = 2;
        while(n>1){
            int c = cons;
            List<Integer> newList = new ArrayList<>();
            for(int i=0;i<c;i++){
                newList.add(work.get(i));
            }
            for(int i=work.size()-1;i>=0;i--){
                newList.add(c | work.get(i));
            }
            work = newList;
            cons = cons*2;
            n--;
        }
        List<Integer> ans = new ArrayList<>();
        int idx = -1;
        for(int i=0;i<work.size();i++){
            if(work.get(i) == start){
                idx = i;
            }
        }
        for(int i=0;i<Math.pow(2,nn);i++){
            idx = idx % work.size();
            ans.add(work.get(idx));
            idx++;
        }
        return ans;
    }

    public static void main(String[] args){

        List<Integer> res = circularPermutation(4,0);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
