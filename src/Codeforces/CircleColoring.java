package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CircleColoring {



    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[][] seqs = new int[n][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<n;j++){
                    seqs[j][i] = sc.nextInt();
                }
            }
            int[] res = new int[n];
            res[0] = seqs[0][0];
            for(int i=1;i<n;i++){
                if(i == n-1){
                    if(seqs[i][0] != res[i-1] && seqs[i][0] != res[0]){
                        res[i] = seqs[i][0];
                    }else if(seqs[i][1] != res[i-1] && seqs[i][1] != res[0]){
                        res[i] = seqs[i][1];
                    }else{
                        res[i] = seqs[i][2];
                    }
                }else{
                    if(seqs[i][0] != res[i-1]){
                        res[i] = seqs[i][0];
                    }else if(seqs[i][1] != res[i-1]){
                        res[i] = seqs[i][1];
                    }else{
                        res[i] = seqs[i][2];
                    }
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(res[i] + " ");
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
