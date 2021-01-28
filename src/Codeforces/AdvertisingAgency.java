package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdvertisingAgency {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        long mod = 1000000007;
        long[][] C = new long[1001][1001];
        C[1][0] = 1;
        C[1][1] = 1;
        for(int i=2;i<=1000;i++){
            for(int j=0;j<=i;j++){
                if(j == 0){
                    C[i][j] = 1;
                }else{
                    C[i][j] = C[i-1][j] + C[i-1][j-1];
                    C[i][j] %= 1000000007;
                }
            }
        }
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            int[] map = new int[1001];
            int[] need = new int[1001];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                map[arr[i]]++;
            }
            long res = 1;
            Arrays.sort(arr);
            for(int i=0;i<k;i++){
                need[arr[n-1-i]]++;
            }
            for(int i=1;i<=n;i++){
                if(need[i]>0) {
                    res *= (C[map[i]][need[i]]);
                    res = res%(1000000007);
                }
            }
            System.out.println(res);
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