package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class WizardofOrz {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            if(n == 1){
                sb.append('9');
                System.out.println(sb.toString());
                continue;
            }
            if(n == 2){
                sb.append("98");
                System.out.println(sb.toString());
                continue;
            }
            if(n == 3){
                sb.append("989");
                System.out.println(sb.toString());
                continue;
            }
            if(n > 3){
                sb.append("989");
                n-=3;
                for(int i=0;i<n;i++){
                    sb.append(i%10);
                }
                System.out.println(sb.toString());
                continue;
            }

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
