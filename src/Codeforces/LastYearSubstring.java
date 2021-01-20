package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LastYearSubstring {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int sz = sc.nextInt();
            String st = sc.nextLine();
            if(st.startsWith("2020") || st.endsWith("2020")){
                System.out.println("YES");
                continue;
            }
            if(st.startsWith("20") && st.endsWith("20")){
                System.out.println("YES");
                continue;
            }
            if(st.startsWith("2") && st.endsWith("020")){
                System.out.println("YES");
                continue;
            }
            if(st.startsWith("202") && st.endsWith("0")){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
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
