package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaximumProduct {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            long[] b=new long[6];
            b[0]=a[n-1]*a[n-2]*a[n-3]*a[n-4]*a[n-5];
            b[1]=a[n-1]*a[n-2]*a[n-3]*a[n-4]*a[0];
            b[2]=a[n-1]*a[n-2]*a[n-3]*a[1]*a[0];
            b[3]=a[n-1]*a[n-2]*a[2]*a[1]*a[0];
            b[4]=a[n-1]*a[3]*a[2]*a[1]*a[0];
            b[5]=a[4]*a[3]*a[2]*a[1]*a[0];
            Arrays.sort(b);
            System.out.println(b[5]);
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
