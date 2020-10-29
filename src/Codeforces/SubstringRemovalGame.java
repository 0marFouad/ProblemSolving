package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubstringRemovalGame {



    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int cnt = 0;
            for(int i=0;i<s.length();i++){
                while(i<s.length() && s.charAt(i) == '1'){
                    cnt++;
                    i++;
                }
                pq.add(cnt);
                cnt = 0;
            }
            int ans = 0;
            while(!pq.isEmpty()){
                ans += pq.poll();
                if(!pq.isEmpty()){
                    pq.poll();
                }
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
