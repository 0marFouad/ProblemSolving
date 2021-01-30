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

            long pos = 0;
            long time = 0;
            long oldPos = 0;
            long oldTime = 0;
            long dir = 1;
            long res = 0;
            boolean removed = false;
            for(int i=0;i<n;i++){
                if(arr[i][0] < time){
                    if(!removed){
                        removed = true;
                        res--;
                    }
                    long start = oldPos + dir*(arr[i][0] - oldTime);
                    long end = pos;
                    if(arr[i][1] >= start && arr[i][1] <= end){
                        res++;
                    }else if(arr[i][1] <= start && arr[i][1] >= end){
                        res++;
                    }
                }else{
                    removed = false;
//                    if(arr[i][1] == pos){
//                        res++;
//                        continue;
//                    }
                    if(arr[i][1] > pos){
                        dir = 1;
                    }else{
                        dir = -1;
                    }
                    oldPos = pos;
                    oldTime = arr[i][0];
                    time = (arr[i][0] + dir*(arr[i][1]-pos));
                    pos = arr[i][1];
                    res++;

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
