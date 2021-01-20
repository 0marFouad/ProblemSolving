package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StrangePartition {



    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long x = sc.nextLong();
            long arr[] = new long[n];
            long max = 0;
            long min = 0;
            for(int  i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(arr[i]%x == 0){
                    max += arr[i]/x;
                }else{
                    max += arr[i]/x;
                    max++;
                }
                min += arr[i];
            }
            long minn = 0;
            if(min % x != 0){
                minn++;
            }
            minn +=  min / x;

            System.out.println(minn + " " + max);
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
