package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GuessingtheGreatest {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        PrintWriter printWriter = new PrintWriter(System.out);
        int l = 1;
        int n = sc.nextInt();
        int r = n;

        HashMap<String,Integer> mp = new HashMap<>();

        while(r-l>=2){
            int mid = l + (r-l)/2;
            int secondHalfGlobal;
            printWriter.println("? "+l+" "+r);
            printWriter.flush();
            secondHalfGlobal = sc.nextInt();

            if(r==l+2){
                if(secondHalfGlobal == l){
                    l++;
                    continue;
                }else if(secondHalfGlobal == r){
                    r--;
                    continue;
                }
            }
            int secondHalf1;
            if(secondHalfGlobal > mid){
                printWriter.println("? "+(mid+1)+" "+r);
                printWriter.flush();
                secondHalf1 = sc.nextInt();
                if(secondHalf1 == secondHalfGlobal){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }else{
                printWriter.println("? "+l+" "+mid);
                printWriter.flush();
                secondHalf1 = sc.nextInt();
                if(secondHalf1 == secondHalfGlobal){
                    r = mid;
                }else{
                    l = mid+1;
                }

            }
        }

        if(l==r){
            printWriter.println("! "+l);
            printWriter.flush();
        }
        if(l==r-1){
            int res;
            printWriter.println("? "+l+" "+r);
            printWriter.flush();
            res = sc.nextInt();
            if(res == l){
                printWriter.println("! "+r);
                printWriter.flush();
            }else{
                printWriter.println("! "+l);
                printWriter.flush();
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
