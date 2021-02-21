package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BalancedRemainders {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int[] rems = new int[3];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                rems[arr[i]%3]++;
            }

            int res = 0;
            int st = n/3;
            for(int j=0;j<3;j++){
                for(int i=0;i<3;i++){
                    if(rems[i]>st){
                        rems[(i+1)%3]+=(rems[i] - st);
                        res+=(rems[i] - st);
                        rems[i] = st;
                    }
                }
            }
            System.out.println(res);


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
