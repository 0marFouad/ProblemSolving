package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class YetAnotherStringGame {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i%2 == 0){
                    if(s.charAt(i) == 'a'){
                        sb.append('b');
                    }else{
                        sb.append('a');
                    }
                }else{
                    if(s.charAt(i) == 'z'){
                        sb.append('y');
                    }else{
                        sb.append('z');
                    }
                }
            }
            System.out.println(sb.toString());
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
