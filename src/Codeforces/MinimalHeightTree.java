package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimalHeightTree {


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            if(n == 2){
                System.out.println(n-1);
                continue;
            }
            int parents = 1;
            ArrayList<Integer> a = new ArrayList<>();
            for(int i=1;i<n;i++){
                int count = 1;
                while(i+1<n && arr[i] < arr[i+1]){
                    i++;
                    count++;
                }
                a.add(count);
            }
            int level = 0;
            int newP = 0;
            boolean flag = false;
            for(int i=0;i<a.size();i++){
                newP += a.get(i);
                flag = false;
                if(parents == 1){
                    parents = newP;
                    newP = 0;
                    level++;
                }else{
                    flag = true;
                    parents--;
                }
            }
            if(flag){
                level++;
            }
            System.out.println(level);
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
