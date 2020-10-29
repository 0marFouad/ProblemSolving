package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArenaGreed {



    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            long n = s.nextLong();
            long ans = 0;
            boolean me = true;
            while(n!=0){
                if(n%4==0 && n > 4){
                    if(me){
                        ans++;
                    }
                    n-=1;
                }else if(n%2==0){
                    if(me){
                        ans += n/2;
                    }
                    n = n/2;
                }else{
                    if(me){
                        ans++;
                    }
                    n-=1;
                }
                me = !me;
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


