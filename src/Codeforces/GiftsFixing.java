package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GiftsFixing {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] a = new long[n];
            long minA = Long.MAX_VALUE;
            long[] b = new long[n];
            long minB = Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
                minA = Math.min(minA,a[i]);
            }
            for(int i=0;i<n;i++){
                b[i] = sc.nextInt();
                minB = Math.min(minB,b[i]);
            }
            long ans = 0;
            for(int i=0;i<n;i++){
                long decA = a[i] - minA;
                long decB = b[i] - minB;
                ans += Math.max(decA,decB);
            }
            System.out.println(ans);
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
