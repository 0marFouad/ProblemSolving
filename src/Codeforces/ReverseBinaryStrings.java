


package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ReverseBinaryStrings {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int i=0;i<n;i++){
                if(i%2==0){
                    sb1.append('0');
                    sb2.append('1');
                }else{
                    sb1.append('1');
                    sb2.append('0');
                }
            }
            for(int i=0;i<n;i++){
                if(sb1.charAt(i) == s.charAt(i)){
                    sb1.setCharAt(i,'0');
                }else{
                    sb1.setCharAt(i,'1');
                }
                if(sb2.charAt(i) == s.charAt(i)){
                    sb2.setCharAt(i,'0');
                }else{
                    sb2.setCharAt(i,'1');
                }
            }
            int ans1 = 0;
            int ans2 = 0;
            for(int i=0;i<sb1.length();i+=0){
                char cur = sb1.charAt(i);
                while(i<n && sb1.charAt(i) == cur){
                    i++;
                }
                if(cur == '1'){
                    ans1++;
                }
            }
            for(int i=0;i<sb2.length();i+=0){
                char cur = sb2.charAt(i);
                while(i<n && sb2.charAt(i) == cur){
                    i++;
                }
                if(cur == '1'){
                    ans2++;
                }
            }
            System.out.println(Math.min(ans1,ans2));
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
