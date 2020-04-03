package Happy_numbers;

import java.util.HashSet;

public class Solution {

    public static int getNext(int x){
        int num = 0;
        while(x > 0){
            num += Math.pow(x%10,2);
            x = x/10;
        }
        return num;
    }

    public static boolean isHappy(int n, HashSet<Integer> mp) {
        if(n == 1){
            return true;
        }
        if(mp.contains(n)){
            return false;
        }
        mp.add(n);
        return isHappy(getNext(n),mp);
    }

    public static boolean isHappy(int n) {
        return isHappy(getNext(n), new HashSet<>());
    }

    public static void main(String[] args){
        System.out.println(isHappy(129));
    }
}
