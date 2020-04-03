package Cut_Off_Trees_for_Golf_Event;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void visit(List<List<Integer>> forest, List<List<Boolean>> visited,int i, int j){
        if(i < 0 || i >= forest.size() || j < 0 || j >= forest.get(i).size()){
            return;
        }
        if(visited.get(i).get(j) || forest.get(i).get(j) == 0){
            return;
        }
        visited.get(i).set(j,true);
        visit(forest,visited,i+1,j);
        visit(forest,visited,i-1,j);
        visit(forest,visited,i,j+1);
        visit(forest,visited,i,j-1);
    }
    public static int dfs(List<List<Integer>> forest, int i, int j){
        if(i < 0 || i >= forest.size() || j < 0 || j >= forest.get(i).size()){
            return Integer.MAX_VALUE;
        }
        if(forest.get(i).get(j) == -1 || forest.get(i).get(j) == 0){
            return Integer.MAX_VALUE;
        }
        int temp = forest.get(i).get(j);
        forest.get(i).set(j,-1);
        int res1 = 1;
        int res2 = Math.min(Math.min(dfs(forest,i+1,j),dfs(forest,i-1,j)),Math.min(dfs(forest,i,j-1),dfs(forest,i,j+1)));
        forest.get(i).set(j,temp);
        if(res2 == Integer.MAX_VALUE){
            return res1;
        }
        return res2+res1;
    }

    public static int cutOffTree(List<List<Integer>> forest) {
        List<List<Boolean>> visited = new ArrayList<>();
        for(int i=0;i<forest.size();i++){
            List<Boolean> l = new ArrayList<>();
            for(int j=0;j<forest.get(i).size();j++){
                l.add(false);
            }
            visited.add(l);
        }
        visit(forest,visited,0,0);
        for(int i=0;i<forest.size();i++){
            for(int j=0;j<forest.get(i).size();j++){
                if(forest.get(i).get(j) != 0 && !visited.get(i).get(j)){
                    return -1;
                }
            }
        }
        int res = dfs(forest,0,0);
        return res - 1;
    }

    public static void main(String[] args){
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(2);
        r1.add(3);
        r1.add(4);
        List<Integer> r2 = new ArrayList<>();
        r2.add(6);
        r2.add(7);
        r2.add(5);
        List<Integer> r3 = new ArrayList<>();
        r3.add(8);
        r3.add(9);
        r3.add(6);
        forest.add(r1);
        forest.add(r2);
        forest.add(r3);
        System.out.println(cutOffTree(forest));
    }
}

//[       [54581641,64080174,24346381,69107959],
//        [86374198,61363882,68783324,79706116],
//        [668150,92178815,89819108,94701471],
//        [83920491,22724204,46281641,47531096],
//        [89078499,18904913,25462145,60813308]]