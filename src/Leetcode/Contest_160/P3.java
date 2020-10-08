package Leetcode.Contest_160;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P3 {


    public static int help(List<String> list, int n){
        int res = 0;
        StringBuilder str = new StringBuilder();
        for(int i=1;i<=list.size();i++){
            int num = n%2;
            if(num == 1){
                str.append(list.get(i-1));
            }
            n = n >> 1;
        }
        HashMap<Character,Integer> t = new HashMap<>();
        for(int i=0;i<str.toString().length();i++){
            if(t.get(str.toString().charAt(i)) != null){
                return 0;
            }else{
                t.put(str.toString().charAt(i),1);
            }
        }
        return str.toString().length();
    }


    public static int maxLength(List<String> arr) {
        if(arr.size() == 0){
            return 0;
        }
        int result = 0;
        for(int i=0;i<=Math.pow(2,arr.size());i++){
            int num = help(arr,i);
            result = Math.max(result,num);
        }
        return result;
    }

    public static void main(String[] args){
        List<String> tr = new ArrayList<>();
        tr.add("un");
        tr.add("iq");
        tr.add("ue");
        System.out.println(maxLength(tr));
    }
}
