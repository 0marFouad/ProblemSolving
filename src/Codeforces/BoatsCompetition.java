package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BoatsCompetition {

    public static int solve(int[] arr, int s, HashMap<Integer, Integer> mp){
        HashSet<Integer> vis = new HashSet<>();
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            int second = s - arr[i];
            if(vis.contains(arr[i])){
                continue;
            }
            if(second == arr[i]){
                ans += mp.get(second);
            }else{
                ans += Math.min(mp.get(arr[i]),mp.getOrDefault(second,0));
            }
            vis.add(arr[i]);
        }
        return ans/2;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                mp.put(arr[i],mp.getOrDefault(arr[i],0) + 1);
            }
            int ans = 0;
            for(int i=1;i<=100;i++){
                int s = i;
                ans = Math.max(ans,solve(arr,s,mp));
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
