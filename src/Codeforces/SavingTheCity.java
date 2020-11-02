package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SavingTheCity {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = sc.next();
            int i = 0;
            while(i<s.length() && s.charAt(i) == '0'){
                i++;
            }
            int j = s.length()-1;
            while(j>=0 && s.charAt(j) == '0'){
                j--;
            }
            if(i == s.length()){
                System.out.println(0);
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            int sections = 0;
            for(int ii=i;ii<=j;ii+=0){
                if(s.charAt(ii)=='0'){
                    int sz = 0;
                    while(ii<s.length() && s.charAt(ii)=='0'){
                        sz++;
                        ii++;
                    }
                    if(sz > 0){
                        list.add(sz);
                    }
                }else{
                    sections++;
                    while(ii<s.length() && s.charAt(ii)=='1'){
                        ii++;
                    }
                }
            }
            Collections.sort(list);
            long ans = sections*a;
            for(int ii=0;ii<list.size();ii++){
                sections--;
                long news = (ans-a) + list.get(ii)*b;
                if(news > ans){
                    break;
                }
                if(ans > news){
                    ans = news;
                }
            }
            System.out.println(ans);
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
