package Codeforces.Two_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args){
        MyScanner s = new Main.MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int T = s.nextInt();
            int[] arr = new int[n];
            int[] res = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = s.nextInt();
                res[i] = -1;
            }

            HashMap<Integer, Integer> mp0 = new HashMap<>();
            HashMap<Integer, Integer> mp1 = new HashMap<>();

            for(int i=0;i<n;i++){
                int getNum = arr[i];
                int oppNum = T - getNum;
                if(mp0.containsKey(oppNum)){
                    if(mp1.containsKey(oppNum)){
                        int dups0 = mp0.getOrDefault(getNum,0);
                        int dups1 = mp1.getOrDefault(getNum,0);
                        boolean isDupGood = (T - getNum) == getNum ? false : true;
                        if(dups0 > dups1){
                            if(isDupGood){
                                mp0.put(getNum,mp0.getOrDefault(getNum,0) + 1);
                                res[i] = 0;
                            }else{
                                mp1.put(getNum,mp1.getOrDefault(getNum,0) + 1);
                                res[i] = 1;
                            }
                        }else{
                            if(isDupGood){
                                mp1.put(getNum,mp1.getOrDefault(getNum,0) + 1);
                                res[i] = 1;
                            }else{
                                mp0.put(getNum,mp0.getOrDefault(getNum,0) + 1);
                                res[i] = 0;
                            }
                        }
                    }else{
                        mp1.put(getNum,mp1.getOrDefault(getNum,0) + 1);
                        res[i] = 1;
                    }
                }else{
                    if(!mp1.containsKey(oppNum)){
                        int dups0 = mp0.getOrDefault(getNum,0);
                        int dups1 = mp1.getOrDefault(getNum,0);
                        boolean isDupGood = (T - getNum) == getNum ? false : true;
                        if(dups0 > dups1){
                            if(isDupGood){
                                mp0.put(getNum,mp0.getOrDefault(getNum,0) + 1);
                                res[i] = 0;
                            }else{
                                mp1.put(getNum,mp1.getOrDefault(getNum,0) + 1);
                                res[i] = 1;
                            }
                        }else{
                            if(isDupGood){
                                mp1.put(getNum,mp1.getOrDefault(getNum,0) + 1);
                                res[i] = 1;
                            }else{
                                mp0.put(getNum,mp0.getOrDefault(getNum,0) + 1);
                                res[i] = 0;
                            }
                        }
                    }else{
                        mp0.put(getNum,mp0.getOrDefault(getNum,0) + 1);
                        res[i] = 0;
                    }
                }

            }
            for(int i=0;i<n;i++){
                System.out.print(res[i] + " ");
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


