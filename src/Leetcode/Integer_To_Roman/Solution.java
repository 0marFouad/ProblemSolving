package Leetcode.Integer_To_Roman;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Integer> freq = new ArrayList<>();
        for(int i=0;i<1001;i++){
            freq.add(0);
        }
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(4,"IV");
        map.put(1,"I");
        map.put(100,"C");
        freq.set(1000, num/1000);
        num = num % 1000;
        freq.set(900, num/900);
        num = num % 900;
        freq.set(500,num/500);
        num = num % 500;
        freq.set(400, num/400);
        num = num % 400;
        freq.set(100,num/100);
        num = num % 100;
        freq.set(90,num/90);
        num = num % 90;
        freq.set(50,num/50);
        num = num % 50;
        freq.set(40,num/40);
        num = num % 40;
        freq.set(10,num/10);
        num = num % 10;
        freq.set(9,num/9);
        num = num % 9;
        freq.set(5,num/5);
        num = num % 5;
        freq.set(4,num/4);
        num = num % 4;
        freq.set(1,num);
        StringBuilder result = new StringBuilder();
        for(int i=1000;i>=0;i--){
            while(freq.get(i) > 0){
                result.append(map.get(i));
                freq.set(i,freq.get(i)-1);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(intToRoman(500));
    }
}
