package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SocialDistance {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] left = new int[n];
            int[] right = new int[n];
            String s = sc.nextLine();
            int saved = k;
            for(int i=0;i<n;i++){
                left[i] = saved;
                if(s.charAt(i) == '0'){
                    saved++;
                }else{
                    saved = 0;
                }
            }
            saved = k;
            for(int i=n-1;i>=0;i--){
                right[i] = saved;
                if(s.charAt(i) == '0'){
                    saved++;
                }else{
                    saved = 0;
                }
            }

            int ans = 0;
            for(int i=0;i<n;i++){
                if(s.charAt(i) == '0' && left[i] >= k && right[i] >= k){
                    ans++;
                    i+=k;
                }
            }
            System.out.println(ans);
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