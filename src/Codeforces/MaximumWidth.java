package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumWidth {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = 1;
        while(t-->0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            String s = sc.next();
            String tt = sc.next();

            int[] left = new int[n-1];
            int[] right = new int[n-1];

            int ptr = 0;
            for(int i=0;i<m&&ptr<n-1;i++){
                if(s.charAt(i) == tt.charAt(ptr)){
                    left[ptr] = i;
                    ptr++;
                }
            }

            ptr = n-1;
            for(int i=m-1;i>=0&&ptr>=1;i--){
                if(s.charAt(i) == tt.charAt(ptr)){
                    right[ptr-1] = i;
                    ptr--;
                }
            }
            int mx = Integer.MIN_VALUE;
            for(int i=0;i<n-1;i++){
                mx = Math.max(mx,right[i] - left[i]);
            }
            System.out.print(mx);



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
