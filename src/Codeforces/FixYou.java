package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FixYou {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int r = sc.nextInt();
            int c = sc.nextInt();
            char[][] grid = new char[r][c];
            for(int i=0;i<r;i++){
                grid[i] = sc.next().toCharArray();
            }
            int ans = 0;
            for(int i=0;i<r;i++){
                int j = c-1;
                if(grid[i][j] == 'R'){
                    ans++;
                }
            }
            for(int j=0;j<c;j++){
                int i = r-1;
                if(grid[i][j] == 'D'){
                    ans++;
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
