package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RedAndBlue {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int as = sc.nextInt();
            int a[] = new int[as];
            int accA[] = new int[as];
            int maxA = 0;
            for(int i=0;i<as;i++){
                a[i] = sc.nextInt();
                if(i == 0){
                    accA[i] = a[i];
                }else{
                    accA[i] = accA[i-1] + a[i];
                }
                maxA = Math.max(maxA,accA[i]);
            }

            int bs = sc.nextInt();
            int b[] = new int[bs];
            int accB[] = new int[bs];
            int maxB = 0;
            for(int i=0;i<bs;i++){
                b[i] = sc.nextInt();
                if(i == 0){
                    accB[i] = b[i];
                }else{
                    accB[i] = accB[i-1] + b[i];
                }
                maxB = Math.max(maxB,accB[i]);
            }
            System.out.println(maxA+maxB);
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
