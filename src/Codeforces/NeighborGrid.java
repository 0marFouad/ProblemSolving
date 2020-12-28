package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NeighborGrid {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[][] arr = new long[n][m];
            long[][] res = new long[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j] = sc.nextLong();
                    res[i][j] = 4;
                    if(i == 0 || j == 0 || i == n-1 || j == m-1){
                        res[i][j]--;
                    }
                }
            }
            res[0][0]--;
            res[0][m-1]--;
            res[n-1][0]--;
            res[n-1][m-1]--;
            boolean solved = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j] > res[i][j]){
                        solved = false;
                        break;
                    }
                }
                if(!solved){
                    break;
                }
            }
            if(!solved){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        System.out.print(res[i][j] + " ");
                    }
                    System.out.println();
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
