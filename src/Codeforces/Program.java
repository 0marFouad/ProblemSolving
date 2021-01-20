package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Program {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            if(n==1){
                while(q-->0){
                    int ff = sc.nextInt();
                    int ss = sc.nextInt();
                    System.out.println(1);
                }
                continue;
            }
            int cur = 0;
            int[] arr = new int[n];
            int[] negs = new int[n];
            int[] pos = new int[n];
            int neg = 0;
            int po = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '-'){
                    cur--;
                    neg++;
                }else{
                    po++;
                    cur++;
                }
                negs[i] = neg;
                pos[i] = po;
                arr[i] = cur;
            }
            int rows = n;
            int cols = (int) Math.ceil(Math.log10(n)/Math.log10(2));
            int[][] spTableMin = new int[rows][cols];
            int[][] spTableMax = new int[rows][cols];
            for(int i=0;i<rows;i++){
                spTableMin[i][0] = i;
                spTableMax[i][0] = i;
            }
            int sz = n;
            int diff = 1;
            for(int i=1;i<cols;i++){
                int idx = 0;
                int second = idx + diff;
                int tempSz = 0;
                while(second < sz){
                    if(arr[spTableMin[idx][i-1]] < arr[spTableMin[second][i-1]]){
                        spTableMin[idx][i] = spTableMin[idx][i-1];
                    }else{
                        spTableMin[idx][i] = spTableMin[second][i-1];
                    }

                    if(arr[spTableMax[idx][i-1]] > arr[spTableMax[second][i-1]]){
                        spTableMax[idx][i] = spTableMax[idx][i-1];
                    }else{
                        spTableMax[idx][i] = spTableMax[second][i-1];
                    }

                    idx++;
                    second++;
                    tempSz++;
                }
                sz = tempSz;
                diff*=2;
            }

            while(q-->0){
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;

                int removed = pos[to] - negs[to];
                if(from>0){
                    removed -= (pos[from-1] - negs[from - 1]);
                }

                int from1 = 0;
                int to1 = from-1;
                int from2 = to+1;
                int to2 = n-1;

                int min1 = Integer.MAX_VALUE;
                int max1 = Integer.MIN_VALUE;
                int min2 = Integer.MAX_VALUE;
                int max2 = Integer.MIN_VALUE;

                boolean flag1 = false;
                if(to1 >= from1){
                    flag1 = true;
                    int l = to1 - from1 + 1;
                    int k = (int) Math.floor(Math.log10(l)/Math.log10(2));
                    int dif = (int) (l - Math.pow(2,k));
                    min1 = Math.min(min1,arr[spTableMin[from1][k]]);
                    min1 = Math.min(min1,arr[spTableMin[from1+dif][k]]);
                    max1 = Math.max(max1,arr[spTableMax[from1][k]]);
                    max1 = Math.max(max1,arr[spTableMax[from1+dif][k]]);
                }

                boolean flag2 = false;
                if(to2 >= from2){
                    flag2 = true;
                    int l = to2 - from2 + 1;
                    int k = (int) Math.floor(Math.log10(l)/Math.log10(2));
                    int dif = (int) (l - Math.pow(2,k));
                    min2 = Math.min(min2,arr[spTableMin[from2][k]]);
                    min2 = Math.min(min2,arr[spTableMin[from2+dif][k]]);
                    min2 -= removed;
                    max2 = Math.max(max2,arr[spTableMax[from2][k]]);
                    max2 = Math.max(max2,arr[spTableMax[from2+dif][k]]);
                    max2 -= removed;
                }


                if(flag1 && flag2){
                    int mx = Math.max(max1,max2);
                    mx = Math.max(mx,0);
                    int mn = Math.min(min1,min2);
                    mn = Math.min(mn,0);
                    System.out.println(mx - mn + 1);
                }
                if(flag1 && !flag2){
                    max1 = Math.max(max1,0);
                    min1 = Math.min(min1,0);
                    System.out.println(max1 - min1 + 1);
                }
                if(!flag1 && flag2){
                    max2 = Math.max(max2,0);
                    min2 = Math.min(min2,0);
                    System.out.println(max2 - min2 + 1);
                }
                if(!flag1 && !flag2){
                    System.out.println(1);
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
