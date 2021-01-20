package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class HillsAndValleys {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long arr[] = new long[n];
            int ans = 0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
            }
            int isHV[] = new int[n];
            for(int i=1;i<n-1;i++){
                if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    isHV[i] = 1;
                    ans++;
                }else if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                    isHV[i] = 1;
                    ans++;
                }
            }
            int finalans = ans;
            for(int i=1;i<n-1;i++){
                long temp = arr[i];
                arr[i] = arr[i-1];
                int dec = isHV[i-1] + isHV[i];
                if(i<n-2){
                    if(arr[i+1] > arr[i] && arr[i+1] > arr[i+2]){
                        dec = dec + isHV[i+1] - 1;
                    }else if(arr[i+1] < arr[i] && arr[i+1] < arr[i+2]){
                        dec = dec + isHV[i+1] - 1;
                    }else{
                        dec += isHV[i+1];
                    }
                }
                finalans = Math.min(finalans, ans - dec);
                arr[i] = temp;
            }

            for(int i=1;i<n-1;i++){
                long temp = arr[i];
                arr[i] = arr[i+1];
                int dec = isHV[i+1] + isHV[i];
                if(i>1){
                    if(arr[i-1] > arr[i] && arr[i-1] > arr[i-2]){
                        dec = dec + isHV[i-1] - 1;
                    }else if(arr[i-1] < arr[i] && arr[i-1] < arr[i-2]){
                        dec = dec + isHV[i-1] - 1;
                    }else{
                        dec += isHV[i-1];
                    }
                }
                finalans = Math.min(finalans, ans - dec);
                arr[i] = temp;
            }
            System.out.println(finalans);


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
