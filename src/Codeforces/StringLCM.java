package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringLCM {

    public static int gcd(int a, int b) {
        int large = Math.max(a,b);
        int small = Math.min(a,b);
        if (small==0) return a;
        return gcd(small,large%small);
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int n1 = s1.length();
            int n2 = s2.length();
            int gcd = gcd(n1,n2);
            int l = (n1*n2)/gcd;
            String s11 = s1;
            String s22 = s2;
            while(s1.length() != l){
                s1 = s1.concat(s11);
            }
            while(s2.length() != l){
                s2 = s2.concat(s22);
            }
            if(s1.equals(s2)){
                System.out.println(s1);
            }else{
                System.out.println(-1);
            }
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
