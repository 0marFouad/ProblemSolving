package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayRestoration {


    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int i=1;
            while((y-x)%(n-i) != 0){
                i++;
            }
            int diff = (y-x)/(n-i);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int num = y;
            while(pq.size()<n && num>0 ){
                pq.add(num);
                num -= diff;
            }
            num = y+diff;
            while(pq.size()<n){
                pq.add(num);
                num += diff;
            }
            int[] arr = new int[n];
            for(int ii=n-1;ii>=0;ii--){
                arr[ii] = pq.poll();
            }
            for(int ii=n-1;ii>=0;ii--){
                System.out.print(arr[ii] + " ");
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


