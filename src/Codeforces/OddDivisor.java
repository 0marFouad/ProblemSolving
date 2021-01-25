package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OddDivisor {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            while(n%2 == 0){
                n = n/2;
            }
            if(n!=1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
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