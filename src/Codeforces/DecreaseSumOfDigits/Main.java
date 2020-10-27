package Codeforces.DecreaseSumOfDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int valid(String str,int s){
        int sum = 0;
        for(int i=0;i<str.length();i++){
            sum += (str.charAt(i) - '0');
            if(sum>s){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        long t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            int s = sc.nextInt();
            StringBuilder sb = new StringBuilder(n+"");
            int i = valid(sb.toString(),s);
            while(i != -1){
                for(int c=i;c<sb.toString().length();c++){
                    sb.setCharAt(c,'0');
                }
                boolean cont = true;
                for(int c=i-1;c>=0;c--){
                    if(!cont){
                        break;
                    }
                    int crnt = sb.charAt(c) - '0';
                    if(crnt < 9){
                        crnt++;
                        String ss = crnt+"";
                        sb.setCharAt(c,ss.charAt(0));
                        cont = false;
                    }else{
                        sb.setCharAt(c,'0');
                    }
                }
                if(cont){
                    sb.insert(0,'1');
                    cont = false;
                }
                i = valid(sb.toString(),s);
            }
            System.out.println(Long.parseLong(sb.toString())- n);
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


