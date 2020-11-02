package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeliveryDilemma {

    public static class Order implements Comparable<Order>{
        long a;
        long b;
        public Order(long a,long b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Order o) {
            return Long.compare(a,o.a);
        }
    }


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextLong();
            }
            PriorityQueue<Order> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<n;i++){
                b[i] = sc.nextLong();
                pq.add(new Order(a[i],b[i]));
            }
            long ans = 0;
            while(!pq.isEmpty()){
                Order c = pq.poll();
                long first = Math.max(ans,c.a);
                long second = ans + c.b;
                ans = Math.min(first,second);
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
