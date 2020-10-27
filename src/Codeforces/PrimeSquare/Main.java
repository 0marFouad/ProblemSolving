package Codeforces.PrimeSquare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
                arr[i][i] = 1;
                arr[i][n-i-1]=1;
            }
            if(n%2==1){
                int mid = n/2;
                arr[mid-1][mid]=1;
                arr[mid+1][mid]=1;
                arr[mid][mid-1]=1;
                arr[mid][mid+1]=1;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
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
