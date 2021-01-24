package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FairNumbers {

    public static boolean isFair(long n){
        long savedn = n;
        while(n!=0){
            long rem = n%10;
            if(rem!=0 && savedn%rem != 0){
                return false;
            }
            n/=10;
        }
        return true;
    }


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            while(!isFair(n)){
                n++;
            }
            System.out.println(n);
        }




//        for(int i=1;i<=300;i++){
//            if(isFair(i)){
//                System.out.println(i);
//            }
//        }


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