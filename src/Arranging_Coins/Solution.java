package Arranging_Coins;

public class Solution {
    public static int arrangeCoins(int n) {
        long nn = 8*(long)n;
        double res = (-1 + Math.sqrt(1+nn))/2;
        double res1 = (-1 - Math.sqrt(1+nn))/2;
        return (int) Math.max(res, res1);
    }

    public static void main(String[] args){
        int x = arrangeCoins(5);
        System.out.println(x);
    }
}
