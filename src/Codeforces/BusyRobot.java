package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BusyRobot {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[][] arr = new long[n][2];
            for(int i=0;i<n;i++){
                arr[i][0] = sc.nextLong();
                arr[i][1] = sc.nextLong();
            }

            long reachPos = 0;
            long reachTime = 0;
            long oldPos = 0;
            long oldTime = 0;
            long dir = 1;
            long res = 0;
            for(int i=0;i<n;i++){
                long ti = arr[i][0];
                long tii;
                if(i==n-1){
                    tii = Long.MAX_VALUE;
                }else{
                    tii = arr[i+1][0];
                }
                if(ti < reachTime){
                    //ignore
                    long start = oldPos + dir*(ti - oldTime);
                    long end;
                    if(tii >= reachTime){
                        end = reachPos;
                    }else{
                        end = oldPos + dir*(tii - oldTime);
                    }
                    if(arr[i][1] >= start && arr[i][1] <= end){
                        res++;
                    }else if(arr[i][1] <= start && arr[i][1] >= end){
                        res++;
                    }
                }else{
                    //execute
                    if(arr[i][1] > reachPos){
                        dir = 1;
                    }else{
                        dir = -1;
                    }
                    oldPos = reachPos;
                    oldTime = ti;
                    reachTime = (ti + dir*(arr[i][1]-reachPos));
                    reachPos = arr[i][1];

                    if(tii >= reachTime){
                        res++;
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
