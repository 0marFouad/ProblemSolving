package Codeforces.ABBB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            Stack<Integer> stk = new Stack<>();
            String str = s.next();
            int tot = 0;
            for(int i=0;i<str.length();i++){
                char cur = str.charAt(i);
                if(cur == 'A'){
                    if(tot<0){
                        stk.push(tot);
                        tot = 0;
                    }
                    tot++;
                }else{
                    if(tot>0){
                        stk.push(tot);
                        tot = 0;
                    }
                    tot--;
                }
            }
            stk.push(tot);

            int storedA = 0;
            if(stk.size()>0){
                if(stk.peek() > 0){
                    storedA = stk.pop();
                }
            }
            while(stk.size()>=2){
                int neg = stk.pop();
                int pos = stk.pop();
                int temp = Math.min(Math.abs(neg),Math.abs(pos));
                neg += temp;
                pos -= temp;
                if(neg!=0){
                    if(stk.size()==0){
                        stk.push(neg);
                    }else{
                        stk.push(stk.pop()+neg);
                    }
                }
                if(pos!=0){
                    storedA += pos;
                }
            }
            if(stk.size()==1){
                int num = -stk.pop();
                storedA += (num%2);
            }
            System.out.println(storedA);
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


