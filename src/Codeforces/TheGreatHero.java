package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TheGreatHero {

    public static class Monster implements Comparable<Monster>{
        long power;
        long health;
        public Monster(long p,long h){
            power = p;
            health = h;
        }

        @Override
        public int compareTo(Monster o) {
            return Long.compare(this.power,o.power);
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            long p = sc.nextLong();
            long h = sc.nextLong();
            int n = sc.nextInt();
            long ps[] = new long[n];
            long hs[] = new long[n];
            for(int i=0;i<n;i++){
                ps[i] = sc.nextLong();
            }
            PriorityQueue<Monster> pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                hs[i] = sc.nextLong();
                Monster m = new Monster(ps[i],hs[i]);
                pq.add(m);
            }

            while(pq.size()>1){
                Monster m = pq.poll();
                long hits = m.health/p;
                m.health -= hits*p;
                if(m.health > 0){
                    hits++;
                }
                h -= hits*m.power;
            }



            if(h<=0){
                System.out.println("NO");
                continue;
            }

            Monster last = pq.poll();
            long hits = last.health/p;
            if(last.health%p != 0){
                hits++;
            }

            long getHits = h/last.power;
            if(h%last.power != 0){
                getHits++;
            }

            if(getHits<hits){
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

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
