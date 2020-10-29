package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CopyPaste {



    public static void main(String[] args){
        MyScanner s = new Codeforces.CopyPaste.MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                pq.add(s.nextInt());
            }
            int ans = 0;
            int small = pq.poll();
            while(!pq.isEmpty() && pq.size()>= 1){
                int large = pq.poll();
                if(large + small > k){
                    break;
                }
                int f = (k - large)/small;
                large += (small*f);
                ans += f;
                pq.add(large);
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


