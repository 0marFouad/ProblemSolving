package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoboniuLikestoColorBalls {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            int evens = 0;
            boolean allEven = false;
            if((r+g+b+w)%2 == 0){
                allEven = true;
            }
            if(r%2==0){
                evens++;
            }
            if(g%2==0){
                evens++;
            }
            if(b%2==0){
                evens++;
            }
            if(w%2==0){
                evens++;
            }
            if(allEven && evens == 4){
                System.out.println("Yes");
                continue;
            }
            if(!allEven && evens == 3){
                System.out.println("Yes");
                continue;
            }
            if(r==0 || b==0 || g == 0){
                System.out.println("No");
                continue;
            }
            if(allEven && evens == 0){
                System.out.println("Yes");
                continue;
            }
            if(!allEven && evens == 1){
                System.out.println("Yes");
                continue;
            }
            System.out.println("No");
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
