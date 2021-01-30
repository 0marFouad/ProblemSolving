package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UniversalSolution {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            int ps = 0;
            int rs = 0;
            int ss = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == 'R'){
                    rs++;
                }
                if(s.charAt(i) == 'P'){
                    ps++;
                }
                if(s.charAt(i) == 'S'){
                    ss++;
                }
            }
            int mx = Math.max(ss,ps);
            mx = Math.max(mx,rs);
            StringBuilder res = new StringBuilder();
            if(rs == mx){
                for(int i=0;i<s.length();i++){
                    res.append('P');
                }
            }else if(ps == mx){
                for(int i=0;i<s.length();i++){
                    res.append('S');
                }
            }else{
                for(int i=0;i<s.length();i++){
                    res.append('R');
                }
            }
            System.out.println(res.toString());
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
