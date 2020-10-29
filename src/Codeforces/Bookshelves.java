package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bookshelves {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int crnt = 0;
            int start = -1;
            int end = n-1;
            for(int i=0;i<n;i++){
                if(start == -1 && arr[i] == 1){
                    start = i;
                }
                if(arr[i] == 1){
                    end = i;
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=start;i<=end;i++){
                if(arr[i]==1){
                    ans.add(crnt);
                    while(i<=end && arr[i] == 1){
                        i++;
                    }
                    i--;
                }else{
                    crnt++;
                }
            }
            if(ans.size() < 2){
                System.out.println(0);
                continue;
            }
            Collections.sort(ans);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<ans.size()-1;i++){
                pq.add(ans.get(i+1) - ans.get(i));
            }
            int res = 0;
            while(pq.size() > 0){
                res += pq.poll();
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


