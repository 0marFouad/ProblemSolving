package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SumofCubes {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        HashSet<Long> hs = new HashSet<>();
        for(long i=1;i<=10000;i++){
            long num = i*i*i;
            hs.add(num);
        }
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            boolean solved = false;
            for(long i=1;i<10000;i++){
                if(n-(i*i*i) < 0){
                    break;
                }
                if(hs.contains(n-(i*i*i))){
                    solved = true;
                    break;
                }
            }
            if(solved){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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
