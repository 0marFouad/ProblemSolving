package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class GuesstheNumber {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        PrintWriter printWriter = new PrintWriter(System.out);
        int l = 1;
        int n = sc.nextInt();
        int r = n;
        int[] arr = new int[n+1];
        if(n==1){
            printWriter.println("! "+1);
            printWriter.flush();
        }

        if(n<3 && n>=2){
            r=1;
            for(int i=1;i<=n;i++){
                printWriter.println("? " + i);
                printWriter.flush();
                arr[i] = sc.nextInt();
            }
            if(arr[1] < arr[2]){
                printWriter.println("! "+1);
                printWriter.flush();
            }else if(arr[n-1] > arr[n]){
                printWriter.println("! "+n);
                printWriter.flush();
            }else{
                for(int i=2;i<n;i++){
                    if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                        printWriter.println("! "+i);
                        printWriter.flush();
                        break;
                    }
                }
            }
        }

        while(l!=r){
            int mid = (r+l)/2;
            if(r == n && l == r-1){
                mid = r;
            }
            if(l == 1 && l == r-1){
                mid = l;
            }

            int n2;
            if(arr[mid] == 0){
                printWriter.println("? " + mid);
                printWriter.flush();
                n2 = sc.nextInt();
            }else{
                n2 = arr[mid];
            }
            arr[mid] = n2;

            int n1;
            if(mid-1 <= 0){
                n1 = n+1;
            }else{
                if(arr[mid-1] == 0){
                    printWriter.println("? " + (mid-1));
                    printWriter.flush();
                    n1 = sc.nextInt();
                }else{
                    n1 = arr[mid-1];
                }
                arr[mid-1] = n1;
            }

            int n3;
            if(mid+1>n){
                n3 = n+1;
            }else{
                if(arr[mid+1] == 0){
                    printWriter.println("? " + (mid+1));
                    printWriter.flush();
                    n3 = sc.nextInt();
                }else{
                    n3 = arr[mid+1];
                }
                arr[mid+1] = n3;
            }

            if(n2 < n1 && n2 < n3){
                printWriter.println("! "+mid);
                printWriter.flush();
                break;
            }

            if(n1 > n2 && n2 > n3){
                l = mid;
            }else {
                r = mid;
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
