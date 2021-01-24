package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class AddtoNeighbourandRemove {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] pref = new int[n];
            HashSet<Integer> hs = new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(i == 0){
                    pref[i] = arr[i];
                }else{
                    pref[i] = pref[i-1]+arr[i];
                }
                hs.add(pref[i]);
            }

            for(int i=n;i>=1;i--){
                if(pref[n-1]%i != 0){
                    continue;
                }

                int step = pref[n-1]/i;
                int current = 0;
                boolean done = true;
                for(int j=0;j<n;j++){
                    current += arr[j];
                    if(current > step){
                        done = false;
                        break;
                    }else if(current == step){
                        current = 0;
                    }
                }
                if(done){
                    System.out.println(n-i);
                    break;
                }
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
