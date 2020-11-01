package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ThreePairwiseMaximums {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
           long[] arr = new long[3];
           for(int i=0;i<3;i++){
               arr[i] = sc.nextLong();
           }
            Arrays.sort(arr);
           if(arr[0] != arr[1] && arr[1] != arr[2]){
               System.out.println("NO");
               continue;
           }
           if(arr[0] == arr[1] && arr[1] != arr[2]){
               System.out.println("NO");
               continue;
           }
           System.out.println("YES");
           System.out.println(arr[0] + " " + arr[0] + " " + arr[1]);
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
