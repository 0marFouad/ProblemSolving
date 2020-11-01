package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RockandLever {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr= new long[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                long num = 1;
                while(num<arr[i]){
                    num*=2;
                }
                if(num > arr[i]){
                    arr[i] = num/2;
                }
            }
            HashMap<Long,Integer> mp = new HashMap<>();
            long ans = 0;
            for(int i=0;i<n;i++){
                if(mp.containsKey(arr[i])){
                    ans += mp.get(arr[i]);
                }
                mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            }
            System.out.println(ans);
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
