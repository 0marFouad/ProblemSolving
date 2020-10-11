package Codeforces.Snow_Footprints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int n = s.nextInt();
        String str = s.next();

        boolean isL = false;
        boolean isR = false;
        int l1 = -1;
        int l2 = -1;
        int r1 = -1;
        int r2 = -1;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'R'){
                isR = true;
                if(r1 == -1){
                    r1 = i;
                    r2 = i;
                }else{
                    r2 = i;
                }
            }
            if(str.charAt(i) == 'L'){
                isL = true;
                if(l1 == -1){
                    l1 = i;
                    l2 = i;
                }else{
                    l2 = i;
                }
            }




        }

        if(isL && !isR){
            l2++;
            System.out.println(l2 + " " + l1);
        }else if(isR && !isL){
            r1++;
            r2+=2;
            System.out.println(r1 + " " + r2);
        }else{
            r1++;
            r2++;
            System.out.println(r1 + " " + r2);
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

