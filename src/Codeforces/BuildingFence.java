package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BuildingFence {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] arr = new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            long[] l = new long[n];
            long[] r = new long[n];
            l[0] = arr[0];
            r[n-1] = arr[n-1];
            for(int i=1;i<n;i++){
                l[i] = Math.min(arr[i] + k - 1,l[i-1] + k - 1);
            }
            for(int i=n-2;i>=0;i--){
                r[i] = Math.min(arr[i] + k - 1,r[i+1] + k - 1);
            }
            long[] res = new long[n];
            res[0] = arr[0];
            res[n-1] = arr[n-1];
            for(int i=1;i<n-1;i++){
                res[i] = Math.min(l[i],r[i]);
            }
            boolean possible = true;
            for(int i=1;i<n;i++){
                if(res[i] < arr[i]){
                    possible = false;
                    break;
                }
                if(Math.abs(res[i] - res[i-1]) > k - 1){
                    possible = false;
                    break;
                }
            }
            if(possible){
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
