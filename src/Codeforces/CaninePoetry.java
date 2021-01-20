package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CaninePoetry {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            StringBuilder sb = new StringBuilder(sc.next());
            int n = sb.length();
            HashSet<Integer> res = new HashSet<>();
            for(int i=0;i<n-2;i++){
                if(sb.charAt(i) != sb.charAt(i+1) && sb.charAt(i+1) != sb.charAt(i+2) && sb.charAt(i) != sb.charAt(i+2)){
                    continue;
                }
                if(sb.charAt(i) == sb.charAt(i+1) && sb.charAt(i+1) == sb.charAt(i+2)){
                    res.add(i+1);
                    res.add(i+2);
                    sb.setCharAt(i+1,'0');
                    sb.setCharAt(i+2,'0');
                    continue;
                }
                if(sb.charAt(i) == sb.charAt(i+1)){
                    sb.setCharAt(i+1,'0');
                    res.add(i+1);
                    continue;
                }
                if(sb.charAt(i) == sb.charAt(i+2)){
                    res.add(i+2);
                    sb.setCharAt(i+2,'0');
                    continue;
                }
                if(sb.charAt(i+1) == sb.charAt(i+2)){
                    res.add(i+2);
                    sb.setCharAt(i+2,'0');
                    continue;
                }
            }
            System.out.println(res.size());
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
