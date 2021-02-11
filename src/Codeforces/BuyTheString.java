package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class BuyTheString {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int c0 = sc.nextInt();
            int c1 = sc.nextInt();
            int h = sc.nextInt();
            String s = sc.next();
            int count0 = 0;
            int count1 = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0'){
                    count0++;
                }else{
                    count1++;
                }
            }
            int res = count0*c0 + count1*c1;
            int res1 = Integer.MAX_VALUE;
            if(c0 + h < c1){
                res1 = h*count1 + (count0+count1)*c0;
            }
            if(c1 + h < c0){
                res1 = Math.min(res1,h*count0 + (count0+count1)*c1);
            }
            System.out.println(Math.min(res,res1));
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
