package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ThreeIndices {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            int maxIdx = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                mp.put(arr[i], i + 1);
            }
            int left[] = new int[n];
            int right[] = new int[n];
            left[0] = arr[0];
            for (int i = 1; i < n; i++) {
                left[i] = Math.min(arr[i], left[i - 1]);
            }
            right[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                right[i] = Math.min(arr[i], right[i + 1]);
            }
            int i = 0;
            for (i = 0; i < n; i++) {
                if (arr[i] > left[i] && arr[i] > right[i]) {
                    break;
                }
            }
            if (i == n) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(mp.get(left[i]) + " " + (i + 1) + " " + mp.get(right[i]));
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
