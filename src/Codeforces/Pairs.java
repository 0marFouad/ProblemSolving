package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Pairs {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                hs.add(sc.nextInt());
            }
            int min = Integer.MAX_VALUE;
            int f = 0;
            for(int i=1;i<=2*n;i++){
                if(hs.contains(i)){
                    f++;
                }else{
                    f--;
                }
                min = Math.min(min,f);
            }
            int res = n+1+min;
            min = Integer.MAX_VALUE;
            f = 0;
            for(int i=2*n;i>=1;i--){
                if(hs.contains(i)){
                    f++;
                }else{
                    f--;
                }
                min = Math.min(min,f);
            }
            res+=min;
            System.out.println(res);
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
