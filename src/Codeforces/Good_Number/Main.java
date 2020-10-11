package Codeforces.Good_Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        int k = s.nextInt();
        int ans = n;
        for(int i=0;i<n;i++){
            String str = s.next();
            int[] flags = new int[10];
            for(int j=0;j<str.length();j++){
                flags[Integer.parseInt(str.charAt(j) + "")]++;
            }
            for(int ii=0;ii<=k;ii++){
                if(flags[ii]==0){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
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

