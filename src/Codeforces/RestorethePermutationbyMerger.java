package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RestorethePermutationbyMerger {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[2*n];
            for(int i=0;i<2*n;i++){
                arr[i] = sc.nextInt();
            }
            HashSet<Integer> mp = new HashSet<>();
            int res[] = new int[n];
            int ptr = 0;
            for(int i=0;i<2*n;i++){
                if(!mp.contains(arr[i])){
                    res[ptr] = arr[i];
                    ptr++;
                    mp.add(arr[i]);
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(res[i] + " ");
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
