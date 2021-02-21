package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EqualizetheArray {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                mp.put(arr[i],mp.getOrDefault(arr[i],0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            long res = 0;
            int sz = 0;
            for (int v : mp.values())
                pq.add(v);
            while(!pq.isEmpty()){
                sz++;
                res = Math.max(sz* pq.poll(),res);
            }
            System.out.println(n - res);
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
