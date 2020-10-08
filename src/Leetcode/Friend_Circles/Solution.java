package Leetcode.Friend_Circles;

class Solution {

    public static int findCirc(int[][] M, int j,boolean[] vis){
        if(vis[j]){
            return 0;
        }
        vis[j] = true;
        for(int i=0;i<M[j].length;i++){
            if(M[j][i] == 1)
                findCirc(M,i,vis);
        }
        return 1;
    }

    public static int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] vis = new boolean[M.length];
        for(int i=0;i<M.length;i++){
            res += findCirc(M,i,vis);
        }
        return res;
    }
}
