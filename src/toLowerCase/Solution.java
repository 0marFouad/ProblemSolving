package toLowerCase;
import java.util.*;

public class Solution {
    public static String toLowerCase(String str) {
        StringBuilder input = new StringBuilder(str);
        for(int i=0;i<input.length();i++){
            if((int)input.charAt(i) < 97 && (int)input.charAt(i) >= 65){
                int a = ((int)input.charAt(i) + 32);
                input.setCharAt(i,(char)a);
            }
        }
        return input.toString();
    }

    public static void main(String[] args){
        System.out.println((int)'A');
        System.out.println(toLowerCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}
