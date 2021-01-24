package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NonSubstringSubsequence {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            for(int i=0;i<q;i++){
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                int ll = 0;
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j) == s.charAt(l)){
                        ll = j;
                        break;
                    }
                }
                int rr = 0;
                for(int j=n-1;j>=0;j--){
                    if(s.charAt(j) == s.charAt(r)){
                        rr = j;
                        break;
                    }
                }

                if(rr - ll > r - l){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
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