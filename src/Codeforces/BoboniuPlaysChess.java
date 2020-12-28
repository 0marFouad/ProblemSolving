package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BoboniuPlaysChess {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        for(int j=sy;j<=m;j++){
            System.out.println(sx + " " + j);
        }
        for(int j=sy-1;j>=1;j--){
            System.out.println(sx + " " + j);
        }
        boolean start = false;
        for(int i=1;i<=n;i++){
            if(i == sx){
                continue;
            }
            if(!start){
                for(int j=1;j<=m;j++){
                    System.out.println(i + " " + j);
                }
            }else{
                for(int j=m;j>=1;j--){
                    System.out.println(i + " " + j);
                }
            }
            start = !start;
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
