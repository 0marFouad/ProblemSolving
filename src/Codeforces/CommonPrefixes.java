package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonPrefixes {

    public static StringBuilder reverse(StringBuilder str, int idx){
        StringBuilder sb = new StringBuilder(str.toString());
        if(sb.toString().charAt(idx) == 'a'){
            sb.setCharAt(idx,'b');
        }else{
            sb.setCharAt(idx,'a');
        }
        return sb;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int mx = 0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                mx = Math.max(arr[i],mx);
            }
            StringBuilder[] res = new StringBuilder[n+1];
            StringBuilder cur = new StringBuilder();
            for(int i=0;i<mx+1;i++){
                cur.append('a');
            }
            res[0] = cur;
            for(int i=0;i<n;i++){
                res[i+1] = new StringBuilder();
                res[i+1] = reverse(res[i],arr[i]);
            }
            for(int i=0;i<res.length;i++){
                System.out.println(res[i]);
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
