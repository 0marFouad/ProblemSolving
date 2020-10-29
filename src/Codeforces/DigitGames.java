package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DigitGames {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            boolean razeodd = false;
            boolean breacheven = false;
            int n = sc.nextInt();
            String num = sc.next();
            char[] arr = num.toCharArray();
            for(int i=0;i<arr.length;i+=2){
                int temp = (arr[i] - '0');
                if(temp%2==1){
                    razeodd = true;
                }
            }
            for(int i=1;i<arr.length;i+=2){
                int temp = (arr[i] - '0');
                if(temp%2==0){
                    breacheven = true;
                }
            }
            if(arr.length % 2 == 1){
                if(razeodd){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }else{
                if(breacheven){
                    System.out.println(2);
                }else{
                    System.out.println(1);
                }
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
