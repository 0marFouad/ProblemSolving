package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SpaceNavigation {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int px = sc.nextInt();
            int py = sc.nextInt();
            String s = sc.next();

            int  x = 0;
            int y = 0;
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == 'R'){
                    x++;
                }
                if(s.charAt(i) == 'L'){
                    x--;
                }
                if(s.charAt(i) == 'U'){
                    y++;
                }
                if(s.charAt(i) == 'D'){
                    y--;
                }
                mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            }
            int diffx = px - x;
            if(diffx > 0){
                if(mp.get('L') != null && mp.get('L') >= diffx){
                    diffx = 0;
                }
            }
            if(diffx < 0){
                if(mp.get('R') != null && mp.get('R') >= -diffx){
                    diffx = 0;
                }
            }

            int diffy = py - y;
            if(diffy > 0){
                if(mp.get('D') != null && mp.get('D') >= diffy){
                    diffy = 0;
                }
            }
            if(diffy < 0){
                if(mp.get('U') != null && mp.get('U') >= -diffy){
                    diffy = 0;
                }
            }
            if(diffx == 0 && diffy == 0){
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
