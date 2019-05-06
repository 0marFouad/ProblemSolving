package Min_Steps_in_Infinite_Grid;

import java.util.*;

public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int numSteps = 0;
        for(int i = 1; i < X.size(); i++){
            numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
        }
        return numSteps;
    }


    public static void main(String[] args) {
        ArrayList<Integer> X = new ArrayList<>();
        X.add(0);
        X.add(1);
        X.add(1);
        ArrayList<Integer> Y = new ArrayList<>();
        Y.add(0);
        Y.add(1);
        Y.add(2);
        System.out.println(coverPoints(X,Y));
    }
}
