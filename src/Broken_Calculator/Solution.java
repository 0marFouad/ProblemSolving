package Broken_Calculator;

import java.util.HashMap;

public class Solution {
    public static int brokenCalc(int X, int Y) {
        if(Y == X){
            return 0;
        }
        int result = 0;
        while(Y>X){
            if(Y%2==0){
                Y/=2;
            }else{
                Y++;
            }
            result++;
        }
        return result + X - Y;
    }

    public static void main(String[] args){
        System.out.println(brokenCalc(5,8));
    }
}
