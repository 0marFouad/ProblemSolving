package Codeforces.Nice_Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long solve(long[][] arr,int n,int m){
        long res = 0;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<(m+1)/2;j++){
                long n1 = arr[i][j];
                long n2 = arr[n-i-1][j];
                long n3 = arr[i][m-j-1];
                long n4 = arr[n-i-1][m-j-1];
                long[] ar = {n1, n2 , n3 , n4};
                Arrays.sort(ar);
                long mid = ar[ar.length/2];
                for(int ii=0;ii<ar.length;ii++){
                    if(i == n-i-1 || j == m-j-1){
                        res += Math.abs(ar[0]-ar[3]);
                        break;
                    }else{
                        res += Math.abs(ar[ii] - mid);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int m = s.nextInt();
            long[][] arr = new long[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j] = s.nextInt();
                }
            }
            System.out.println(solve(arr,n,m));
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


