package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OmkarandInfinityClock {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String k = sc.next();
            int kk = k.charAt(k.length()-1);
            long[] arr = new long[n];
            long mx = Long.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
                mx = Math.max(mx,arr[i]);
            }
            long mx1 = Long.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i] = mx-arr[i];
                mx1 = Math.max(mx1,arr[i]);
            }
            if(kk%2==0){
                for(int i=0;i<n;i++){
                    arr[i] = mx1-arr[i];
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
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
