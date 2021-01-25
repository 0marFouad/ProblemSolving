package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortSubstrings {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            for(int i=1;i<s.length()-1;i+=2){
                sb.append(s.charAt(i));
            }
            sb.append(s.charAt(s.length()-1));
            System.out.println(sb.toString());
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