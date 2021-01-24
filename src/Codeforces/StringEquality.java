package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringEquality {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            int[] a1 = new int[26];
            int[] a2 = new int[26];
            for(int i=0;i<n;i++){
                a1[s1.charAt(i) - 'a']++;
                a2[s2.charAt(i) - 'a']++;
            }
            int[] res = new int[26];
            boolean isdone = false;
            for(int i=0;i<26;i++){
                res[i] = a1[i]-a2[i];

            }
            int ans = 0;
            for(int i=0;i<26;i++){
                if(res[i] % k != 0){
                    ans = 10;
                    break;
                }else{
                    ans += (res[i]/k);
                }
                if(ans < 0){
                    break;
                }
            }



//            for(int i=25;i>=0;i--){
//                if(-res[i]%k != 0){
//                    break;
//                }
//                if((-res[i]) >= k){
//                    for(int j=i-1;j>=0;j--){
//                        if(res[j] >= k){
//                            while(res[j] >= k && -res[i] >= k){
//                                res[j] -= k;
//                                res[i] += k;
//                            }
//                        }
//                    }
//                }
//            }
//
//            int ans = 0;
//            for(int i=0;i<25;i++){
//                ans += Math.abs(res[i]);
//            }

            if(ans == 0){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }


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