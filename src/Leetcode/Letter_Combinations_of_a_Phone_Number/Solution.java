package Leetcode.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void rec(HashMap<Character,List<String>> map, String digits,List<String> result,String resultString,int idx){
        if(idx==digits.length()){
            result.add(resultString);
            return;
        }
        List<String> l = map.get(digits.charAt(idx));

        for(int i=0;i<l.size();i++){
            String newOne = l.get(i);
            rec(map,digits,result,resultString + newOne,idx+1);
        }
    }


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character,List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put('2',list);
        list = new ArrayList<>();
        list.add("d");
        list.add("e");
        list.add("f");
        map.put('3',list);
        list = new ArrayList<>();
        list.add("g");
        list.add("h");
        list.add("i");
        map.put('4',list);
        list = new ArrayList<>();
        list.add("j");
        list.add("k");
        list.add("l");
        map.put('5',list);
        list = new ArrayList<>();
        list.add("m");
        list.add("n");
        list.add("o");
        map.put('6',list);
        list = new ArrayList<>();
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        map.put('7',list);
        list.add("t");
        list.add("u");
        list.add("v");
        map.put('8',list);
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
        map.put('9',list);


        rec(map,digits,result,"",0);
        return result;
    }

    public static void main(String[] args){
        List<String> result = letterCombinations("23");
    }
}
