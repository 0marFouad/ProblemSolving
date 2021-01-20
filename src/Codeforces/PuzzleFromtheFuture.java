package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PuzzleFromtheFuture {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder res = new StringBuilder();
            char last = 'a';
            for(int i=0;i<n;i++){
                if(s.charAt(i) == '0'){
                    if(last == '0'){
                        res.append('1');
                        last = '1';
                    }else if(last == '1'){
                        res.append('0');
                        last = '0';
                    }else if(last == '2'){
                        res.append('1');
                        last = '1';
                    }else{
                        res.append('1');
                        last = '1';
                    }
                }else if(s.charAt(i) == '1'){
                    if(last == '0'){
                        res.append('1');
                        last = '2';
                    }else if(last == '1'){
                        res.append('1');
                        last = '2';
                    }else if(last == '2'){
                        res.append('0');
                        last = '1';
                    }else{
                        res.append('1');
                        last = '2';
                    }
                }
            }
            System.out.println(res.toString());
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
