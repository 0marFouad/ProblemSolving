package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CeilDivisions {

    public static int divCeil(int num, int den){
        if(num%den == 0){
            return num/den;
        }else{
            return (num+den)/den;
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            if(n == 2){
                System.out.println(0);
                continue;
            }
            ArrayList<String> res = new ArrayList<>();
            int num = 8;
            int cur = 3;
            for(int i=cur;i<n;i++){
                if(i != 8){
                    int curp = i+1;
                    res.add(i + " " + curp);
                }
            }
            int m = n;
            int nn = n;
            int i = n;
            if(i>8){
                while(i > 1){
                    res.add(nn + " 8");
                    i = divCeil(i,8);
                }
                res.add("8 2");
                res.add("8 2");
                res.add("8 2");
            }
            if(m<=8){
                while(nn != 1){
                    res.add(m+ " 2");
                    nn=divCeil(nn,2);
                }
            }
            System.out.println(res.size());
            for(i=0;i<res.size();i++){
                System.out.println(res.get(i));
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
