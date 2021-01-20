package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RegularBracketSeq {

    public static boolean test(String s, int l, int r){
        int i = l;
        int j = r;
        while(i<j){
            if(s.charAt(i) != ')' && s.charAt(j) != '('){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();



        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            int left = -1;
            int right = -1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '('){
                    left = i;
                }
                if(s.charAt(i) == ')'){
                    right = i;
                }
            }
            if(s.length()%2 == 1){
                System.out.println("NO");
                continue;
            }
            if(left == right - 1){
                System.out.println("YES");
                continue;
            }
            boolean f1 = false;
            boolean f2 = false;
            for(int i=left+1;i<s.length();i++){
                if(s.charAt(i) == ')' || s.charAt(i) == '?'){
                    f1 = true;
                    break;
                }
            }
            for(int i=right-1;i>=0;i--){
                if(s.charAt(i) == '<' || s.charAt(i) == '?'){
                    f2 = true;
                    break;
                }
            }
            if(f1 && f2){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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
