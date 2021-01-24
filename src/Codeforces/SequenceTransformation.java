package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SequenceTransformation {


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

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            HashSet<Integer> mp = new HashSet<>();
            int[] arr = new int[n];
            int[] acc = new int[n+1];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            mp.add(arr[0]);
            for(int i=1;i<n;i++){
                if(arr[i] != arr[i-1]){
                    acc[arr[i-1]]++;
                }
                if(!mp.contains(arr[i])){
                    acc[arr[i]]++;
                }
                mp.add(arr[i]);
            }
            int mx = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                mx = Math.min(mx,acc[arr[i]]);
            }
            System.out.println(mx);
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