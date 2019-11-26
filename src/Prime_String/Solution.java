package Prime_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static int C2A(char c){
        return (int)c;
    }

    public static char A2C(int c){
        return  (char)c;
    }

    public static char getChar(char c){
        int code = C2A(c);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int leftCode = -1;
        int rightCode = -1;
        boolean isCapital = (code >= 65 && code <= 90);
        if(isPrime(code)){
            return c;
        }
        int leftBound = 65;
        int rightBound = 90;
        if(!isCapital){
            leftBound = 97;
            rightBound = 122;
        }
        for(int i=code-1;i>=leftBound;i--){
            if(isPrime(i)){
                left = code - i;
                leftCode = i;
                break;
            }
        }
        for(int i=code+1;i<=rightBound;i++){
            if(isPrime(i)){
                right = i - code;
                rightCode = i;
                break;
            }
        }
        if(left <= right){
            return A2C(leftCode);
        }else{
            return A2C(rightCode);
        }
    }




    public static List<Integer> subsetA(List<Integer> arr) {
        if(arr.size() == 0){
            return arr;
        }
        Collections.sort(arr);
        List<Integer> res = new ArrayList<>();
        int total = 0;
        for(int i=0;i<arr.size();i++){
            total += arr.get(i);
        }
        int sum = 0;
        for(int i=arr.size()-1;i>=0;i--){
            res.add(0,arr.get(i));
            total -= arr.get(i);
            sum += arr.get(i);
            if(sum>total){
                return res;
            }
        }
        return res;
    }

    public static long change(String n,char x,char p){
        for(int i=0;i<n.length();i++){
            n = n.replaceAll(x+"",p+"");
        }
        return Long.parseLong(n);
    }



    public static long findRange(int num) {
        // Write your code here
        String n = num+"";
        long max = 0;
        for(char j='0';j<='9';j++){
            max = Math.max(max,change(n,j,'9'));
        }
        long min = Long.parseLong(n);
        for(int i=0;i<n.length();i++){
            for(char j='0';j<='9';j++){
                for(char k='0';k<='9';k++){
                    if(n.charAt(0) == j){
                        min = Math.min(min,change(n,j,k));
                    }
                }
            }
        }
        return max-min;
    }


    



    public static void main(String[] args){
        System.out.println(findRange(21));
    }
}
