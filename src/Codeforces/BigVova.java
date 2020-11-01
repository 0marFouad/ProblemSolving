package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BigVova {

    public static int gcd(int s, int l){
        if(Math.min(s,l) == 0){
            return Math.max(s,l);
        }
        int ll = Math.max(s,l);
        int ss = Math.min(s,l);
        return gcd(ll%ss,ss);
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            for(int i=0;i<n;i++){
                list.add(sc.nextInt());
                if(list.get(list.size()-1) > max){
                    max = list.get(list.size()-1);
                    maxIdx = i;
                }
            }
            ArrayList<Integer> res = new ArrayList<>();
            res.add(max);
            list.remove(maxIdx);
            int maxGcd = max;
            for(int i=1;i<n;i++){
                int nn = -1;
                int idx = -1;
                int saved = Integer.MIN_VALUE;
                for(int j=0;j<list.size();j++){
                    int g = gcd(maxGcd,list.get(j));
                    if(g > saved){
                        saved = g;
                        nn = list.get(j);
                        idx = j;
                    }
                }
                maxGcd = saved;
                res.add(nn);
                list.remove(idx);
            }
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
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
