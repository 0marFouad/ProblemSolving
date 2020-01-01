package Repeated_Substring_Pattern;

import java.util.ArrayList;

class Solution {

    public static boolean testDivision(String s, int n){
        if(s.length()%n != 0){
            return false;
        }
        n = s.length()/n;
        String ref = s.substring(0,n);
        for(int i=n;i<s.length();i+=n){
            String cur = s.substring(i,i+n);
            if(!cur.equals(ref)){
                return false;
            }
        }
        return true;
    }

    public static boolean repeatedSubstringPattern(String s) {
        boolean[] isprime = new boolean[s.length()+1];
        isprime[0] = true;
        isprime[1] = true;
        for(int i=2;i<=s.length();i++){
            if(!isprime[i]){
                for(int j=2*i;j<=s.length();j+=i){
                    isprime[j] = true;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i=0;i<=s.length();i++){
            if(!isprime[i]){
                primes.add(i);
            }
        }

        for(int i=0;i<primes.size();i++){
            if(testDivision(s,primes.get(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(repeatedSubstringPattern("abab"));
    }
}