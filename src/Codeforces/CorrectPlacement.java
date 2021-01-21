package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CorrectPlacement {

    static class Rectangle implements Comparable<Rectangle>{
        long h;
        long w;
        int idx;
        public Rectangle(long h,long w,int idx){
            this.h = h;
            this.w = w;
            this.idx = idx;
        }

        @Override
        public int compareTo(Rectangle o) {
            return Long.compare(this.h,o.h);
        }
    }

    public static int binarySearch(Rectangle[] arr, long searchFor){
        int l = 0;
        int r = arr.length-1;
        int mid = l + (r-l)/2;
        while(l < r-1){
            if(arr[mid].h >= searchFor){
                r = mid - 1;
            }else{
                l = mid;
            }
            mid = l + (r-l)/2;
        }
        if(arr[l].h >= searchFor){
            return -1;
        }
        if(arr[r].h < searchFor){
            return r;
        }
        return l;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[][] arr = new long[n][2];
            Rectangle[] arrH = new Rectangle[n];
            Rectangle[] arrW = new Rectangle[n];
            int[] resH = new int[n];
            int[] resW = new int[n];
            int[] minsH = new int[n];
            int[] minsW = new int[n];
            minsH[0] = 0;
            minsW[0] = 0;
            for(int i=0;i<n;i++){
                long w = sc.nextLong();
                long h = sc.nextLong();
                arr[i][0] = h;
                arr[i][1] = w;
                Rectangle r1 = new Rectangle(w,h,i+1);
                Rectangle r2 = new Rectangle(h,w,i+1);
                arrH[i] = r2;
                arrW[i] = r1;
                resH[i] = -1;
                resW[i] = -1;
            }
            Arrays.sort(arrH);
            Arrays.sort(arrW);

            for(int i=1;i<n;i++){
                if(arrH[minsH[i-1]].w < arrH[i].w){
                    minsH[i] = minsH[i-1];
                }else{
                    minsH[i] = i;
                }

                if(arrW[minsW[i-1]].w < arrW[i].w){
                    minsW[i] = minsW[i-1];
                }else{
                    minsW[i] = i;
                }
            }


            for(int i=0;i<n;i++){
                long h = arr[i][0];
                long w = arr[i][1];

                int idxH = binarySearch(arrH,h);

                if(idxH == -1){
                    continue;
                }

                Rectangle possible = arrH[minsH[idxH]];

                if(w > possible.w){
                    resH[i] = possible.idx;
                }


            }


            for(int i=0;i<n;i++){
                long h = arr[i][0];
                long w = arr[i][1];

                int idxW = binarySearch(arrW,h);

                if(idxW == -1){
                    continue;
                }

                Rectangle possible = arrW[minsW[idxW]];

                if(w > possible.w){
                    resW[i] = possible.idx;
                }


            }


            for(int i=0;i<n;i++){
                if(resW[i] == -1){
                    resW[i] = resH[i];
                }
            }

            for(int i=0;i<n;i++){
                System.out.print(resW[i] + " ");
            }
            System.out.println();

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