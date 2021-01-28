package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SuffixOperations {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            if(n == 1){
                System.out.println(0);
                continue;
            }
            int[] arr = new int[n];
            long cost = 0;
            int dups = 0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(i>0){
                    cost += Math.abs(arr[i] - arr[i-1]);
                }
            }
            n = n - dups;
            long minCost = cost;
            for(int i=1;i<n-1;i++){
                if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                    minCost = Math.min(minCost, cost - 2*(arr[i] - Math.max(arr[i-1],arr[i+1])));
                }
                if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                    minCost = Math.min(minCost, cost - 2*(Math.min(arr[i-1],arr[i+1]) - arr[i]));
                }
            }
            minCost = Math.min(minCost, cost - Math.abs(arr[0] - arr[1]));
            minCost = Math.min(minCost, cost - Math.abs(arr[n-2] - arr[n-1]));

            System.out.println(minCost);




        }
    }



    public static int[] sort(int arr[]) {

        List<Integer> list = new ArrayList<>();
        for(int i:arr)
            list.add(i);
        Collections.sort(list);
        for(int i = 0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;

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