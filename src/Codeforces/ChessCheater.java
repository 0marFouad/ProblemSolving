package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ChessCheater {


    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            String str = s.next();
            int firstW = -1;
            int lastW = -1;
            int loses = 0;
            int score = 0;
            for(int i=0;i<n;i++){
                if(str.charAt(i) == 'W'){
                    if( firstW == -1){
                        firstW = i;
                    }
                    lastW = i;
                    score++;
                    if (i < n - 1) {
                        if(str.charAt(i+1) == 'W'){
                            score++;
                        }
                    }
                }else{
                    loses++;
                }
            }
            if(k == 0){
                System.out.println(score);
                continue;
            }
            if(firstW == -1){
                System.out.println(score + 2*Math.min(n,k)-1);
                continue;
            }

            PriorityQueue<Integer> twoSided = new PriorityQueue<>();
            for(int i=firstW;i<=lastW;i++){
                int segment = 0;
                while(str.charAt(i) == 'L'){
                    segment++;
                    i++;
                }
                if(segment!=0)
                    twoSided.add(segment);
            }
            while(k>0 && !twoSided.isEmpty()){
                int seg = twoSided.poll();
                if(seg<=k){
                    score += 2*seg + 1;
                    k -= seg;
                    loses -= seg;
                }else{
                    score += Math.min(loses,k)*2;
                    k = 0;
                }
            }
            score += Math.min(loses,k)*2;
            System.out.println(score);

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


