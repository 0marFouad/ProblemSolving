package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bargain {

    public static long mod = 1000000007;

    public static long power(long a,long b,long m)
    {
        long res=1;

        while(b>0)
        {
            if(b%2!=0)
            {
                res=(res%m*a%m)%m;
            }

            b=b/2;
            a=(a%m*a%m)%m;
        }

        return res;
    }

    public static void main(String[] args){
        MyScanner s = new MyScanner();
        String str = s.next();
        long p = 1;
        long cnt = 1;
        long old = 0;
        long ans = 0;
        for(int i=str.length()-1;i>=0;i--){
            long left = ((long)i*((long)i+1))/2;
            int num = Integer.parseInt(str.charAt(i)+"");
            ans = ((ans%mod) + (((left%mod)*(p%mod))%mod*(num))%(mod))%mod;
            ans = (ans%mod + (num*(old%mod))%mod)%mod;
            old = (old%mod + ((cnt%mod * power(10,(str.length()-1-i),mod))%mod))%mod;
            cnt++;
            p = (p*10)%mod;
        }
        System.out.println(ans%mod);

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


