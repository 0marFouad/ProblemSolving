package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumTies {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        HashMap<Integer,String> results = new HashMap<>();
        while(t-->0){
            int n = sc.nextInt();
            if(results.containsKey(n)){
                System.out.println(results.get(n));
            }
            if(n==2){
                System.out.println(0);
                continue;
            }
            ArrayList<Integer> res = new ArrayList<>();
            n--;
            for(int i=0;i<n/2;i++){
                res.add(1);
            }
            if(n%2==1){
                res.add(0);
            }
            for(int i=0;i<n/2;i++){
                res.add(-1);
            }
            int f = res.size()-1;
            for(int j=f;j>=1;j--){
                for(int i=0;i<j;i++){
                    res.add(res.get(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<res.size();i++){
                sb.append(res.get(i) + " ");
            }
            results.put(n,res.toString());
            System.out.println(sb.toString());
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
