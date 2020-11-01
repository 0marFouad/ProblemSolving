package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SageBirthday_easy {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        int ptr = 0;
        long[] res = new long[n];
        for(int i=1;i<n;i+=2){
            res[i] = arr[ptr];
            ptr++;
        }
        for(int i=0;i<n;i+=2){
            res[i] = arr[ptr];
            ptr++;
        }
        int ans = 0;
        for(int i=1;i<n-1;i+=2){
            if(res[i] < res[i-1] && res[i] < res[i+1]){
                ans++;
            }
        }
        System.out.println(ans);
        for(int i=0;i<n;i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();
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
