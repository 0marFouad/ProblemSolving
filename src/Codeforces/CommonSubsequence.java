package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CommonSubsequence {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            HashSet<Integer> mp = new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i=0;i<m;i++){
                mp.add(sc.nextInt());
            }
            boolean flag = false;
            int i=0;
            for(i=0;i<n;i++){
                if(mp.contains(arr[i])){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
                System.out.println(1 + " " + arr[i]);
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
