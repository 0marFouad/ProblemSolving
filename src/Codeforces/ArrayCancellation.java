package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class ArrayCancellation {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            PriorityQueue<Integer> indices = new PriorityQueue<>();
            long cost = 0;
            for(int i=0;i<n;i++){
                if(arr[i] > 0){
                    indices.add(i);
                }
                if(arr[i] < 0){
                    while(!indices.isEmpty() && arr[i] < 0){
                        int idx = indices.poll();
                        long min = Math.min(arr[idx],Math.abs(arr[i]));
                        arr[idx] -= min;
                        arr[i] += min;
                        if(arr[idx] > 0){
                            indices.add(idx);
                        }
                    }
                }
            }
            for(int i=0;i<n;i++){
                if(arr[i] < 0){
                    cost -= arr[i];
                }
            }
            System.out.println(cost);
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
