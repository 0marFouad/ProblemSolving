package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RadioTowers {

    static int MOD = 998244353;

    static long modInverse(long a, long m)
    {
        return power(a, m - 2, m);
    }

    static long power(long x, long y, long m)
    {
        if (y == 0)
            return 1;

        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % m;
    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long nCrModPFermat(long[] fac,int n, int r, int p)
    {

        if (n<r)
            return 0;

        if (r == 0)
            return 1;


        return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) % p;
    }





    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int g = n;
        if(g%2 == 0){
            g--;
        }
        long x = 0;
        long[] fac = new long[n + 1];
        fac[0] = 1;

        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<=n;i++){
            fib[i] = (fib[i-1] + fib[i-2])%MOD;
        }

        for (int i = 1; i <= n; i++)
            fac[i] = (fac[i - 1] * i) % 998244353;
        while(g>=1){
            int num = n/g;
            int ones = n-g*num;
            x += nCrModPFermat(fac,num+ones,num,998244353);
            g-=2;
            x = x%998244353;
        }
        long y = power(2,n,998244353);
        System.out.println(fib[n]*modInverse(y,998244353) % 998244353);



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
