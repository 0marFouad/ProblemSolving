package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PokemonArmy_easy {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr= new int[n];
            long[][] dp = new long[2][n+1];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i=n-1;i>=0;i--){
                dp[0][i] = Math.max(arr[i] + dp[1][i+1],dp[0][i+1]);
                dp[1][i] = Math.max(-arr[i] + dp[0][i+1],dp[1][i+1]);
            }
            System.out.println(dp[0][0]);
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
