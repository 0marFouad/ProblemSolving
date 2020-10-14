package Codeforces.Amazing_Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args){
        MyScanner s = new Main.MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();


            int[] diff = new int[n+1];
            int[] last = new int[n+1];
            int[] inp = new int[n];
            int[] res = new int[n];
            Arrays.fill(diff,-1);
            Arrays.fill(last,-1);
            Arrays.fill(res,-1);
            for(int i=0;i<n;i++){
                inp[i] = s.nextInt();
            }


            for(int i=0;i<n;i++){
                int num = inp[i];
                diff[num] = Math.max(diff[num],i-last[num]);
                last[num] = i;
            }

            for(int i=1;i<=n;i++){
                int num = i;
                diff[num] = Math.max(diff[num],n-last[num]);

                for (int ii = diff[num]-1; ii < n && res[ii] == -1; ++ii) {
                    res[ii] = num;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            System.out.println(sb);
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


