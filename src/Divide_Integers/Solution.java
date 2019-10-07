package Divide_Integers;
import java.util.*;
public class Solution {
    public static int divide(int A, int B) {
        int ans = 0;
        int neg = 1;
        long AA = A;
        if(A<0){
           AA = -A;
        }
        long BB = B;
        if(B<0){
            BB = B*-1;
        }
        if(A == -2147483648){
            AA = 2147483647;
            AA++;
        }

        while(AA>=BB){
            ans++;
            AA-=BB;
        }

        if(A<0 && B>=0){
            neg = -1;
        }else if(A>=0 && B < 0){
            neg = -1;
        }
        return neg*ans;
    }
    public static void main(String[] args){
        System.out.print(divide(-2147483648,-1));
    }
}
