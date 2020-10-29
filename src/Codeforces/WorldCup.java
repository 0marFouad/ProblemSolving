package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WorldCup {

    public static int getLevel(int from,int to,int a, int b,int level){
        int median = from - 1 + (to - from + 1)/2;
        if(to-1==from){
            return level;
        }
        if(a<=median && b>median){
            return level;
        }
        if(a<=median){
            return getLevel(from,median,a,b,level-1);
        }else{
            return getLevel(median+1,to,a,b,level-1);
        }
    }


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp = Math.min(a,b);
        int temp2 = Math.max(a,b);
        a = temp;
        b = temp2;
        int level = (int) (Math.log10(n)/Math.log10(2));
        int level2 = level;
        int ans = getLevel(1,n,a,b,level);
        if(ans == level2){
            System.out.print("Final!");
        }else{
            System.out.print(getLevel(1,n,a,b,level));
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


