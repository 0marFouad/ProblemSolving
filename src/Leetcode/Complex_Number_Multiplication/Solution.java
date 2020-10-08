package Leetcode.Complex_Number_Multiplication;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> splitter(String num){
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        for (int i=0;i<num.length();i++){
            if(num.charAt(i) == '+'){
                second.append(num.substring(i+1));
                break;
            }else{
                first.append(num.charAt(i));
            }
        }
        Integer f = Integer.parseInt(first.toString());
        Integer s = Integer.parseInt(second.toString());
        List<Integer> l = new ArrayList<>();
        l.add(f);
        l.add(s);
        return l;
    }


    public static String complexNumberMultiply(String a, String b) {
        List<Integer> num1 = splitter(a.substring(0,a.length()-1));
        List<Integer> num2 = splitter(b.substring(0,b.length()-1));
        Integer n1 = num1.get(0) * num2.get(0);
        Integer n2 = num1.get(1) * num2.get(1);
        Integer n3 = num1.get(1) * num2.get(0);
        Integer n4 = num1.get(0) * num2.get(1);
        Integer f = n1 - n2;
        Integer s = n3 + n4;
        StringBuilder result = new StringBuilder(f+"");
        result.append("+");
        result.append(s);
        result.append("i");
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(complexNumberMultiply("1+1i","1+1i"));
    }
}
