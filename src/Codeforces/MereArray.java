package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MereArray {

    public static long gcd(long x,long y){
        long s = Math.min(x,y);
        long l = Math.max(x,y);
        if (s == 0){
            return l;
        }
        return gcd(l%s,s);
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            long arr[] = new long[n];
            long min = Long.MAX_VALUE;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
                min = Math.min(min,arr[i]);
            }
            for(int i=0;i<n;i++){
                if(arr[i]%min == 0){
                    pq.add(arr[i]);
                }
            }
            boolean flag = true;
            for(int i=0;i<arr.length;i++){
                if(arr[i]%min==0){
                    arr[i] = pq.poll();
                }
            }
            for(int i=0;i<n-1;i++){
                if(arr[i] > arr[i+1]){
                    flag = false;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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
