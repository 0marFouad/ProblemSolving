package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubsetMex {



    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            }

            int mexA = 0;
            while(mp.containsKey(mexA)){
                if(mp.get(mexA) == 1){
                    mp.remove(mexA);
                }else{
                    mp.put(mexA,mp.get(mexA)-1);
                }
                mexA++;
            }

            int mexB = 0;
            while(mp.containsKey(mexB)){
                if(mp.get(mexB) == 1){
                    mp.remove(mexB);
                }else{
                    mp.put(mexB,mp.get(mexB)-1);
                }
                mexB++;
            }
            System.out.println(mexA+mexB);
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
