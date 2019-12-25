package Next_Greater_Element_III;

import java.util.Arrays;

class Solution {


    public static String swap(String s, int i, int j){
        String ret = "";
        for(int k=0;k<s.length();k++){
            if(k == i){
                ret += s.charAt(j);
            }else if(k == j){
                ret += s.charAt(i);
            }else{
                ret += s.charAt(k);
            }
        }
        return ret;
    }

    public static boolean isThereNext(String n){
        String num = n;
        for(int i=0;i<num.length()-1;i++){
            if(num.charAt(i) < num.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    public static String replace(String s){
        char first = s.charAt(0);
        int idx = -1;
        char comp = first;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i) > first && idx == -1){
                idx = i;
                comp = s.charAt(i);
            }
            if(s.charAt(i) > first && idx != -1 && comp >= s.charAt(i)){
                idx = i;
                comp = s.charAt(i);
            }
        }

        s = swap(s,0,idx);
        String small = s.substring(1);
        char tempArray[] = small.toCharArray();
        Arrays.sort(tempArray);
        return s.charAt(0) + String.valueOf(tempArray);
    }

    public static String nextGreaterElementS(String n) {
        int idx = -1;
        if(!isThereNext(n)){
            return "-1";
        }else{
            for(int i=n.length()-2;i>=0;i--){
                if(n.charAt(i) < n.charAt(i+1) && idx == -1){
                    idx = i;
                }
            }
        }
        return n.substring(0,idx) + replace(n.substring(idx));
    }

    public static int nextGreaterElement(int n) {
        Long num = Long.parseLong(nextGreaterElementS(n+""));
        if(num > Integer.MAX_VALUE){
            return -1;
        }
        return Integer.parseInt(nextGreaterElementS(n+""));
    }

    public static void main(String[] args){
        System.out.println(nextGreaterElement(12));
    }
}
