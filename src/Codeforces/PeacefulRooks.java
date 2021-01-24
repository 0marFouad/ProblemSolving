package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PeacefulRooks {

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean[] vis,int current,int from){
        if(current == from && vis[current]){
            return true;
        }
        if(vis[current]){
            return false;
        }
        vis[current] = true;
        boolean res = false;
        for(int i=0;i<adj.get(current).size();i++){
            res = res | isCycle(adj,vis, adj.get(current).get(i),from);
        }
        return res;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){

            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
            for(int i=0;i<=n;i++){
                adj.add(new ArrayList<>());
                visited[i] = false;
            }

            int done = 0;

            for(int i=0;i<m;i++){
                int p = sc.nextInt();
                int q = sc.nextInt();
                if(p == q){
                    done++;
                    continue;
                }
                adj.get(p).add(q);
            }

            int cycles = 0;
            for(int i=1;i<=n;i++){
                int from = i;
                if(!visited[i] && isCycle(adj,visited,i,i)){
                    cycles++;
                }
            }
            System.out.println(m - done + cycles);

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