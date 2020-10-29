package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BoxIsPull {
    private static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }
        int DFSUtil(int v, boolean visited[]) {
            visited[v] = true;
            int n;
            Iterator<Integer> i = adj[v].iterator();
            int ans = 0;
            while (i.hasNext()) {
                n = i.next();
                if (!visited[n])
                    ans += DFSUtil(n, visited);
            }
            ans++;
            return ans;
        }
        Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                Iterator<Integer> i = adj[v].listIterator();
                while (i.hasNext())
                    g.adj[i.next()].add(v);
            }
            return g;
        }

        void fillOrder(int v, boolean visited[], Stack stack) {
            visited[v] = true;
            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    fillOrder(n, visited, stack);
            }
            stack.push(new Integer(v));
        }

        int printRes() {
            Stack stack = new Stack();
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    fillOrder(i, visited, stack);

            Graph gr = getTranspose();
            for (int i = 0; i < V; i++)
                visited[i] = false;
            int ans = 0;
            while (stack.empty() == false) {
                int v = (int) stack.pop();
                if (visited[v] == false) {
                    int f = gr.DFSUtil(v, visited);
                    if(f>1){
                        ans+=f;
                    }
                }
            }
            return ans;
        }
    }
        public static void main(String[] args){

        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            Graph g = new Graph(n);
            String str = s.next();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '-'){
                    g.addEdge(i,(i+1)%n);
                    g.addEdge((i+1)%n,i);
                }else if(str.charAt(i) == '>'){
                    g.addEdge(i,(i+1)%n);
                }else{
                    g.addEdge((i+1)%n,i);
                }
            }
            System.out.println(g.printRes());
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


