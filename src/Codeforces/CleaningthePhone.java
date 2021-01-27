package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CleaningthePhone {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            long m = sc.nextLong();
            long[][] arr = new long[n][2];
            ArrayList<Long> ones = new ArrayList<>();
            ArrayList<Long> twos = new ArrayList<>();
            for(int i=0;i<n;i++){
                arr[i][0] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                arr[i][1] = sc.nextInt();
                if(arr[i][1] == 1){
                    ones.add(arr[i][0]);
                }else{
                    twos.add(arr[i][0]);
                }
            }
            Collections.sort(ones, Collections.reverseOrder());
            Collections.sort(twos, Collections.reverseOrder());

            long sum = 0;
            long min = 0;
            int oi = -1;
            int ti = -1;
            long savedMin = Long.MAX_VALUE;
            for(int i=0;i<ones.size() && sum<m;i++){
                sum += ones.get(i);
                min++;
                oi = i;
            }
            if(sum >= m){
                savedMin = Math.min(savedMin,min);
            }
            for(int i=0;i<twos.size();i++){
                while(sum>=m && oi >= 0){
                    sum -= ones.get(oi);
                    oi--;
                    min--;
                    if(sum>=m){
                        savedMin = Math.min(savedMin,min);
                    }
                }
                sum += twos.get(i);
                min+=2;
                if(sum>=m){
                    savedMin = Math.min(savedMin,min);
                }
            }
            while(sum>=m && oi >= 0){
                sum -= ones.get(oi);
                oi--;
                min--;
                if(sum>=m){
                    savedMin = Math.min(savedMin,min);
                }
            }

            if(savedMin == Long.MAX_VALUE){
                savedMin = -1;
            }
            System.out.println(savedMin);

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