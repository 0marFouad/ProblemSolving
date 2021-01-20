package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DifferentDivisors {

    public static boolean isPrime(int p){
        for(int i=2;i<=Math.sqrt(p);i++){
            if(p%i == 0){
                return false;
            }
        }
        return true;
    }

    public static int getPrime(int b) {
        int bb = b;
        while(!isPrime(bb)){
            bb++;
        }
        return bb;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int d = sc.nextInt();
            int f1 = 1;
            int f2 = getPrime(f1+d);
            int f3 = getPrime(f2+d);
            System.out.println(f2*f3);
        }

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
