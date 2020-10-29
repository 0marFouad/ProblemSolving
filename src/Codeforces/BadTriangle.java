package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BadTriangle {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            long firstMin = Long.MAX_VALUE;
            int firstIdx = -1;
            long secondMin = Long.MAX_VALUE;
            int secondIdx = -1;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
                if(arr[i] < firstMin){
                    firstMin = arr[i];
                    firstIdx = i;
                }
            }
            for(int i=0;i<n;i++){
                if (i != firstIdx && arr[i] < secondMin){
                    secondMin = arr[i];
                    secondIdx = i;
                }
            }
            boolean flag = false;
            for(int i=0;i<n;i++){
                if(i != firstIdx && i != secondIdx){
                    if(arr[i]>=firstMin+secondMin){
                        int[] ar = new int[3];
                        ar[0] = firstIdx+1;
                        ar[1] = secondIdx+1;
                        ar[2] = i+1;
                        Arrays.sort(ar);
                        System.out.println(ar[0] + " " + ar[1] + " " + ar[2]);
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag)
                System.out.println(-1);
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
