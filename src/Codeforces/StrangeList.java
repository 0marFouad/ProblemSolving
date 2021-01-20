package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StrangeList {



    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long x = sc.nextLong();
            long[] arr = new long[n];
            long[] levels = new long[n];
            long ans = 0;
            long minLevel = Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
                long temp = arr[i];
                int cnt = 1;
                while(temp % x == 0){
                    cnt++;
                    temp /= x;
                }
                levels[i] = cnt;
                minLevel = Math.min(minLevel,levels[i]);
            }
            boolean found = false;
            for(int i=0;i<n;i++){
                if(levels[i] == minLevel){
                    found = true;
                }
                if(!found){
                    levels[i] = minLevel+1;
                }else{
                    levels[i] = minLevel;
                }
            }
            for(int i=n-1;i>=0;i--){
                ans += arr[i]*levels[i];
            }
            System.out.println(ans);

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
