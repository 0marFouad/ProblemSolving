package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class StrangeBirthdayParty {

    static class Present implements Comparable<Present>{
        long price;
        long count;
        public Present(long price, long count){
            this.count = count;
            this.price = price;
        }

        @Override
        public int compareTo(Present o) {
            return Long.compare(o.price,this.price);
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            PriorityQueue<Present> pq = new PriorityQueue<>();
            HashMap<Long, Present> mp = new HashMap<>();
            int[] K = new int[n];
            long[] C = new long[m];
            for(int i=0;i<n;i++){
                K[i] = sc.nextInt();
            }

            for(int i=0;i<m;i++){
                C[i] = sc.nextLong();
            }

            for(int i=0;i<n;i++){
                int idx = K[i] - 1;
                if(mp.containsKey(C[idx])){
                    mp.get(C[idx]).count++;
                }else{
                    Present p = new Present(C[idx],1);
                    mp.put(C[idx],p);
                    pq.add(p);
                }
            }
            long res = 0;
            for(int i=0;i<C.length && !pq.isEmpty();i++){
                if(C[i] < pq.peek().price){
                    res+=C[i];
                    pq.peek().count--;
                    if(pq.peek().count == 0){
                        pq.poll();
                    }
                }else{
                    break;
                }
            }
            while(!pq.isEmpty()){
                res += (pq.peek().count * pq.peek().price);
                pq.poll();
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
