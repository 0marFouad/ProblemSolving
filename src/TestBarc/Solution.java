package TestBarc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Solution {
    public static String countChars(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder result = new StringBuilder();
        for(char i='a';i<='z';i++){
            if(map.get(i) != null){
                result.append(i);
                result.append(map.get(i)+"");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(countChars(line));
        }
    }
}
