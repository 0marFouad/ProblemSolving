package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Game01 {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0) {
            String s = sc.next();
            Stack<Integer> q = new Stack<>();
            for(int i=0;i<s.length();i+=0){
                int cnt = 0;
                char c = s.charAt(i);
                while(i<s.length() && s.charAt(i) == c){
                    cnt++;
                    i++;
                }
                if(cnt!=0){
                    q.add(cnt);
                }
            }
            int ans = 0;
            while(q.size() >= 2){
                int n1 = q.pop();
                int n2 = q.pop();
                ans += Math.min(n1,n2);
                if(n1 != n2){
                    if(n1 < n2){
                        q.add(Math.max(n1,n2) - Math.min(n1,n2));
                    }else{
                        if(q.size()>0){
                            q.add(q.pop() + Math.max(n1,n2) - Math.min(n1,n2));
                        }
                    }
                }
            }
            if(ans%2 == 0){
                System.out.println("NET");
            }else{
                System.out.println("DA");
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
