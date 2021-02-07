package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class NewColony {

    public static int getFirstAfter(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i] > arr[i-1]){
                return i-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int res = -1;
            for(int i=0;i<n;i++){
                while(getFirstAfter(arr) != -1 && k > 0){
                    int idx = getFirstAfter(arr);
                    arr[idx]++;
                    k--;
                    res = idx+1;
                }
            }
            if(k != 0){
                System.out.println(-1);
                continue;
            }
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
