package Codeforces.CubeSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            boolean same = false;
            HashSet<Long> mp = new HashSet();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(mp.contains(arr[i])){
                    same = true;
                }
                mp.add(arr[i]);
            }
            if(same){
                System.out.println("YES");
                continue;
            }
            boolean flag = false;
            for(int i=1;i<n;i++){
                if(arr[i] > arr[i-1]){
                    flag = true;
                }
            }
            if(flag){
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
