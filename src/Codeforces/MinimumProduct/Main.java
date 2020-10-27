package Codeforces.MinimumProduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String multiply(String num1, String num2)
    {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0)
            return "0";

        // will keep the result number in vector
        // in reverse order
        int result[] = new int[len1 + len2];

        // Below two indexes are used to
        // find positions in result.
        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--)
        {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            i_n2 = 0;
            for (int j = len2 - 1; j >= 0; j--)
            {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
                carry = sum / 10;
                result[i_n1 + i_n2] = sum % 10;
                i_n2++;
            }
            if (carry > 0)
                result[i_n1 + i_n2] += carry;
            i_n1++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;
        if (i == -1)
            return "0";
        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
    }

    static boolean compareStrings(String s1, String s2){
        if(s1.length() > s2.length()){
            return true;
        }
        if(s1.length() < s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) > s2.charAt(i)){
                return true;
            }else if(s1.charAt(i) < s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            long a = s.nextLong();
            long b = s.nextLong();
            long x = s.nextLong();
            long y = s.nextLong();
            long n = s.nextLong();
            String first;
            String second;
            long nn = n;
            long diff = a - Math.max(x,a-n);
            n -= diff;
            a -= diff;
            long diff2 = b - Math.max(y,b-n);
            b -= diff2;
            first = multiply(a+"",b+"");
            a += diff;
            b += diff2;
            diff = b - Math.max(y,b-nn);
            b -= diff;
            nn -= diff;
            diff2 = a - Math.max(x,a-nn);
            a -= diff2;
            second = multiply(a+"",b+"");
            if(compareStrings(first,second)){
                System.out.println(second);
            }else{
                System.out.println(first);
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


