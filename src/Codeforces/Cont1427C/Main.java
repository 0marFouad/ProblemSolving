package Codeforces.Cont1427C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
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

    private static class Node{
        int t,x,y,best;
        public Node(int t,int x,int y){
            this.t = t;
            this.x = x;
            this.y = y;
            this.best = 0;
        }

        public boolean canReach(Node n){
            if(Math.abs(t - n.t) >= Math.abs(x - n.x) + Math.abs(y - n.y)){
                return true;
            }
            return false;
        }

    }
    static MyScanner s = new MyScanner();


    public static void main(String[] args){
        int r = s.nextInt();
        int c = s.nextInt();



        ArrayList<Node> input = new ArrayList<>();
        input.add(new Node(0,1,1));
        for(int i=0;i<c;i++){
            int t = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            Node newNode = new Node(t,x,y);
            if(input.get(0).canReach(newNode)){
                input.add(newNode);
            }
        }
        int[] dp = new int[input.size()+1];
        int[] max_ans = new int[input.size()+1];
        for(int i=1;i<input.size();i++){
            Node from = input.get(i);
            dp[i] = Integer.MIN_VALUE;
            for(int j=Math.max(0,i-2*r);j<i;j++){
                Node to = input.get(j);
                if(from.canReach(to)){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }

                if (i > 2*r){
                    dp[i] = Math.max(dp[i], 1 + max_ans[i-2*r]);
                }
                //accumilated
                max_ans[i] = Math.max(dp[i], max_ans[i-1]);

            }
        }

        System.out.println(max_ans[input.size()-1]);


    }
}
