package Codeforces.Edu96B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){//1 3 5
//1 2 2
//
            int l = s.nextInt();
            int k = s.nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<>(l, Collections.reverseOrder());
            long min = Long.MAX_VALUE;
            for(int i=0;i<l;i++){
                long y = s.nextInt();
                pq.add(y);
                min = Math.min(min,y);
            }
            long max = pq.poll();
            while(!pq.isEmpty() && k>0){
                long getOne = pq.poll();
                max += getOne;
                k--;
                getOne = 0;
                pq.add(getOne);
            }
            System.out.println(max);
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
