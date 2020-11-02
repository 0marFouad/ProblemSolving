package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TernarySequence {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int Bzeros = sc.nextInt();
            int Bones = sc.nextInt();
            int Btwos = sc.nextInt();
            int Azeros = sc.nextInt();
            int Aones = sc.nextInt();
            int Atwos = sc.nextInt();
            long ans = 0;
            int f = Math.min(Btwos,Aones);
            Btwos -= f;
            Aones -= f;
            ans += 2*f;
            f = Math.min(Bones,Azeros);
            Bones -= f;
            Azeros -= f;
            f = Math.min(Bones,Aones);
            Bones -= f;
            Aones -= f;
            ans -= 2*Math.min(Bones,Atwos);
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
