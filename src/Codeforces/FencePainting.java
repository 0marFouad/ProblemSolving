package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FencePainting {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[m];
            Stack<Integer>[] needs = new Stack[n+1];
            int[] indices = new int[n+1];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
                needs[i] = new Stack<>();
                indices[i] = -1;
            }
            needs[n] = new Stack<>();
            indices[n] = -1;
            for(int i=0;i<n;i++){
                b[i] = sc.nextInt();
                indices[b[i]] = i+1;
                if(b[i] != a[i]){
                    needs[b[i]].push(i);
                }
            }
            for(int i=0;i<m;i++){
                c[i] = sc.nextInt();
            }

            if(needs[c[m-1]].isEmpty() && indices[c[m-1]] == -1){
                System.out.println("NO");
                continue;
            }
            ArrayList<Integer> res = new ArrayList<>();
            int saved = -1;
            boolean solvable = true;
            for(int i=m-1;i>=0;i--){
                if(!needs[c[i]].isEmpty()){
                    int idx = needs[c[i]].pop() + 1;
                    res.add(idx);
                    saved = idx;
                }else{
                    if(indices[c[i]] != -1){
                        res.add(indices[c[i]]);
                        saved = indices[c[i]];
                    }else{
                        if(saved == -1){
                            System.out.println("NO");
                            solvable = false;
                            break;
                        }
                        res.add(saved);
                    }
                }
            }
            if(!solvable){
                continue;
            }
            for(int i=0;i<=n;i++){
                if(!needs[i].isEmpty()){
                    System.out.println("NO");
                    solvable = false;
                    break;
                }
            }
            if(!solvable){
                continue;
            }
            System.out.println("YES");
            for(int i=res.size()-1;i>=0;i--){
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
