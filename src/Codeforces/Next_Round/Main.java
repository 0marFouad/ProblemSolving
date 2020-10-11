package Codeforces.Next_Round;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        int ans = k;
        k--;
        for(int j=k+1;j<n;j++){
            if(arr[j]==arr[k]){
                ans++;
            }else{
                break;
            }
        }
        k = ans;
        ans = 0;
        for(int i=0;i<k;i++){
            if(arr[i] > 0){
                ans++;
            }
        }
        System.out.println(ans);


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


