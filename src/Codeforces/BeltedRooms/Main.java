package Codeforces.BeltedRooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        long[][] arr = new long[t][2];
        int i=0;
        while(t>i){
            long st = s.nextLong();
            long en = s.nextLong();
            arr[i][0] = st;
            arr[i][1] = en;
            i++;
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                return Long.compare(a[1], b[1]);
            }
        });
        long ans = 1;
        long max = 1;
        long startYear;
        long st = arr[0][0];
        startYear = st;
        long end = arr[0][1];
        i=1;
        while(i<t){
            long invStart = arr[i][0];
            long invEnd = arr[i][1];
            if(invStart < end){
                ans++;
                st = invStart;
                end = invEnd;
                if(ans>max){
                    max = ans;
                    startYear = st;
                }else if(ans==max){
                    startYear = Math.min(startYear,st);
                }
            }else{
                st = invStart;
                end = invEnd;
                ans = 1;
            }
            i++;
        }
        System.out.println(startYear + " " + max);
    }




/*
6
1 2
1 3
1 5
4 5
4 6
4 7
 */








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


