package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DominantPiranha {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            long max = Long.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                arr[i] = sc.nextLong();
                max = Math.max(max,arr[i]);
            }
            boolean isAll = true;
            for(int i=0;i<n;i++){
                if(arr[i] != max){
                    isAll = false;
                    break;
                }
            }
            if(isAll){
                System.out.println(-1);
                continue;
            }
            for(int i=0;i<n;i++){
                if(arr[i] == max){
                    if(i>0){
                        if(arr[i-1] < max){
                            System.out.println(i+1);
                            break;
                        }
                    }
                    if(i<n-1){
                        if(arr[i+1] < max){
                            System.out.println(i+1);
                            break;
                        }
                    }
                }
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


