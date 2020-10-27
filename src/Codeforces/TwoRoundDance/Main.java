package Codeforces.TwoRoundDance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static long factorial(int n){
        long arr[] = new long[21];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<=20;i++){
            arr[i] = arr[i-1]*i;
        }
        return arr[n];
    }

    public static long nCr(int n, int r){
        long ans = factorial(n)/factorial(r);
        return ans/factorial(n-r);
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        long first = nCr(n,n/2);
        long second = factorial(n/2 - 1);
        second = second*second;
        second = second*first;
        second = second/2;
        System.out.println(second);
    }








    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

}


