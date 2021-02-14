package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ToyBlocks {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            long res = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int mx = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                pq.add(arr[i]);
                mx = Math.max(mx,arr[i]);
            }
            int smallest = pq.poll();
            while(smallest > 0){
                int num = pq.poll();
                if(num == mx){
                    if(smallest<(n-1)){
                        num++;
                        smallest--;
                        mx++;
                    }else{
                        int toAdd = smallest/(n-1);
                        num+=toAdd;
                        smallest-=toAdd;
                        mx+=toAdd;
                    }
                }else{
                    int num1 = num;
                    num += Math.min((mx - num),smallest);
                    smallest -= Math.min((mx - num1),smallest);
                }
                pq.add(num);
            }

            while (!pq.isEmpty()){
                res += (mx - pq.poll());
            }
            System.out.println(res);

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
