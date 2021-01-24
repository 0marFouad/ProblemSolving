package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InGameChat {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String s = sc.nextLine();
            boolean isBad = true;
            int cntBad = 0;
            int cntNormal = 0;
            for(int i=n-1;i>=0;i--){
                if(s.charAt(i) == ')' && isBad){
                    cntBad++;
                }else{
                    isBad = false;
                    cntNormal++;
                }
            }
            if(cntBad > cntNormal){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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