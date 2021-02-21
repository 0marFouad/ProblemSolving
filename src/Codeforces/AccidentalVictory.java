package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class AccidentalVictory {
    public static class Player implements Comparable<Player>{
        long tokens;
        int id;
        public Player(long t,int i){
            this.tokens = t;
            this.id = i;
        }

        @Override
        public int compareTo(Player o) {
            return Long.compare(this.tokens,o.tokens);
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            ArrayList<Player> arr = new ArrayList<>();
            long[] pref = new long[n];
            for(int i=0;i<n;i++){
                long y = sc.nextLong();
                arr.add(new Player(y,i+1));
            }
            if(n==1){
                System.out.println(1);
                System.out.println(1);
                continue;
            }
            Collections.sort(arr);
            pref[0] = arr.get(0).tokens;
            for(int i=1;i<arr.size();i++){
                pref[i] = pref[i-1] + arr.get(i).tokens;
            }
            ArrayList<Integer> res = new ArrayList<>();
            res.add(arr.get(arr.size()-1).id);
            for(int i=n-2;i>=0;i--){
                if(arr.get(i) == arr.get(i+1)){
                    res.add(arr.get(i).id);
                    continue;
                }
                if(pref[i] >= arr.get(i+1).tokens){
                    res.add(arr.get(i).id);
                }else{
                    break;
                }
            }
            Collections.sort(res);
            System.out.println(res.size());
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
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
