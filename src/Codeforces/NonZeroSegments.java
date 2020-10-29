package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NonZeroSegments {

    private static class Interval implements Comparable<Interval>{
        long start;
        long end;
        public Interval(long start, long end){
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Interval o) {
            return Long.compare(this.end,o.end);
        }
    }


    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        long arr[] = new long[n];
        long acc[] = new long[n];
        HashMap<Long, Integer> mp = new HashMap<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        long lastZero = -1;
        for(int i=0;i<n;i++) {
            arr[i] = s.nextInt();
            if(i==0){
                acc[i] = arr[i];
            }else{
                acc[i] = acc[i-1] + arr[i];
            }
            if(acc[i] == 0){
                pq.add(new Interval(lastZero+1,i));
                lastZero = i;
            }else if(mp.containsKey(acc[i])) {
                pq.add(new Interval(mp.get(acc[i])+1,i));
            }
            mp.put(acc[i],i);
        }

        int ans = 0;
        long start = -1;
        long end = -1;
        if(pq.isEmpty()){
            System.out.println(0);
            return;
        }
        ans++;
        start = pq.peek().start;
        end = pq.poll().end;
        while(!pq.isEmpty()){
            Interval inv = pq.poll();
            if(inv.start < end){
                start = Math.max(start,inv.start);
                end = Math.min(end,inv.end);
            }else{
                start = inv.start;
                end = inv.end;
                ans++;
            }
        }
        System.out.println(ans);
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


