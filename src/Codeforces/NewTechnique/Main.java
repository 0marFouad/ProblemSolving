package Codeforces.NewTechnique;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            HashMap<Integer,int[]> mp = new HashMap<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j] = sc.nextInt();
                }
                mp.put(arr[i][0],arr[i]);
            }
            int[][] res = new int[m][n];
            int crnt = -1;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    res[i][j] = sc.nextInt();
                    if(mp.containsKey(res[i][j])){
                        crnt = i;
                    }
                }
            }
            OutputStream out = new BufferedOutputStream( System.out );
            for(int i=0;i<n;i++){
                int[] getRow = mp.get(res[crnt][i]);
                for(int j=0;j<m;j++){
                    out.write((getRow[j] + " ").getBytes());
                }
                out.write("\n".getBytes());
            }
            out.flush();
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


