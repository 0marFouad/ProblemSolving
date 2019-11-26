package Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static List<Integer> getArray(String s){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<26;i++){
            res.add(0);
        }
        for(int i=0;i<s.length();i++){
            res.set(s.charAt(i) - 'a',res.get(s.charAt(i) - 'a') + 1);
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            List<Integer> arr = getArray(strs[i]);
            if(map.get(arr) != null){
                res.get(map.get(arr)).add(strs[i]);
            }else{
                List<String> newList = new ArrayList<>();
                List<Integer> ar = getArray(strs[i]);
                newList.add(strs[i]);
                map.put(ar,res.size());
                res.add(newList);
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println("Omarr");
    }
}
