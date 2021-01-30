package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Journey {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String s = sc.next();
            int[] res = new int[n+1];
            char cur = s.charAt(0);
            int alt = 1;
            for(int i=0;i<=n;i++){
                res[i] = 1;
            }
            for(int i=1;i<=n;i++){
                if(s.charAt(i-1) == 'R'){
                    if(cur != s.charAt(i-1)){
                        alt++;
                    }else{
                        alt = 1;
                    }
                    cur = 'R';
                }else{
                    if(cur != s.charAt(i-1)){
                        alt++;
                    }else{
                        alt=1;
                    }
                    res[i] += alt;
                    cur = 'L';
                }
            }

            cur = s.charAt(s.length()-1);
            alt = 1;
            for(int i=n-1;i>=0;i--){
                if(s.charAt(i) == 'L'){
                    if(cur != s.charAt(i)){
                        alt++;
                    }else{
                        alt = 1;
                    }
                    cur = 'L';
                }else{
                    if(cur != s.charAt(i)){
                        alt++;
                    }else{
                        alt=1;
                    }
                    res[i] += alt;
                    cur = 'R';
                }
            }
            for(int i=0;i<=n;i++){
                System.out.print(res[i] + " ");
            }
            System.out.println();
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
