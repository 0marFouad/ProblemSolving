package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PuttingBricksintheWall {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            char[][] arr = new char[n][n];
            for(int i=0;i<n;i++){
                arr[i] = sc.next().toCharArray();
            }
            int s1 = arr[0][1] - '0';
            s1 += arr[1][0] - '0';
            int s2 = arr[n-1][n-2] - '0';
            s2 += arr[n-2][n-1] - '0';
            if((s1 == 0 && s2 == 2)|| (s1 == 2 && s2 == 0)){
                System.out.println(0);
            }
            if((s1 == 0 && s2 == 1)|| (s1 == 1 && s2 == 0)){
                System.out.println(1);
                if(arr[0][1] == '1'){
                    System.out.println(2 + " " + 1);
                }
                if(arr[1][0] == '1'){
                    System.out.println(1 + " " + 2);
                }
                if(arr[n-1][n-2] == '1'){
                    System.out.println(n-1 + " " + n);
                }
                if(arr[n-2][n-1] == '1'){
                    System.out.println(n + " " + (n-1));
                }
            }
            if((s1 == 2 && s2 == 1)|| (s1 == 1 && s2 == 2)){
                System.out.println(1);
                if(arr[0][1] == '0'){
                    System.out.println(2 + " " + 1);
                }
                if(arr[1][0] == '0'){
                    System.out.println(1 + " " + 2);
                }
                if(arr[n-1][n-2] == '0'){
                    System.out.println(n-1 + " " + n);
                }
                if(arr[n-2][n-1] == '0'){
                    System.out.println(n + " " + (n-1));
                }
            }
            if((s1 == 0 && s2 == 0)||(s1 == 0 && s2 == 0)){
                System.out.println(2);
                System.out.println(1 + " " + 2);
                System.out.println(2 + " " + 1);
            }
            if((s1 == 2 && s2 == 2)||(s1 == 2 && s2 == 2)){
                System.out.println(2);
                System.out.println(1 + " " + 2);
                System.out.println(2 + " " + 1);
            }
            if((s1 == 1 && s2 == 1)||(s1 == 1 && s2 == 1)){
                System.out.println(2);
                if(arr[0][1] == '1'){
                    System.out.println(1 + " " + 2);
                }
                if(arr[1][0] == '1'){
                    System.out.println(2 + " " + 1);
                }
                if(arr[n-1][n-2] == '0'){
                    System.out.println(n + " " + (n-1));
                }
                if(arr[n-2][n-1] == '0'){
                    System.out.println(n-1 + " " + (n));
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
