package Leetcode.Pascal_Triangle_I;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nCr(int n, int r){
        r = Math.min(r,n-r);
        double ans=1;
        for (int i = 0; i < r; ++i){
            ans *= (n - i);
            ans /= (i + 1);
        }
        return (int)ans;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<=i;j++){
                l.add(nCr(i,j));
            }
            res.add(l);
        }
        return res;
    }

}
