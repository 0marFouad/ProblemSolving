package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSimpleCycle {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] c = new int[n];
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0;i<n;i++){
                c[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                b[i] = sc.nextInt();
            }


            long maxRes = 0;
            long resSoFar = c[n-1] + 1;
            for(int i=n-2;i>=0;i--){
                //test deadlock
                if(a[i+1] == b[i+1]){
                    maxRes = Math.max(maxRes, resSoFar);
                    resSoFar = c[i] + 1;
                    continue;
                }
                //try close
                long close = resSoFar + Math.abs(a[i+1] - b[i+1]);
                maxRes = Math.max(maxRes, close);
                //try to continue
                if(i==0){
                    continue;
                }

                if(b[i+1] > a[i+1]){
                    resSoFar += (c[i] - b[i+1]) + (a[i+1] - 1);
                }else{
                    resSoFar += (c[i] - a[i+1]) + (b[i+1] - 1);
                }
                resSoFar+=2;

                //test dismiss last saved
                if(c[i] + 1 > resSoFar && i != 0){
                    resSoFar = c[i] + 1;
                    continue;
                }
            }
            System.out.println(maxRes);

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
