package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HugeBoxesofAnimalToys {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0) {
            int[] arr = new int[4];
            String[] res = new String[4];
            for(int i=0;i<4;i++){
                arr[i] = sc.nextInt();
                res[i] = "Tidak";
            }
            if((arr[0]+arr[1])%2 == 0){
                int nums = arr[0] + arr[3];
                int fracs = arr[1] + arr[2];
                if(nums == 0 && fracs != 0){
                    res[2] = "Ya";
                }
                if(nums != 0 && fracs == 0){
                    res[3] = "Ya";
                }
                if(nums != 0 && fracs != 0){
                    res[2] = "Ya";
                    res[3] = "Ya";
                }
            }else{
                int nums = arr[0] + arr[3];
                int fracs = arr[1] + arr[2];
                if(nums == 0 && fracs != 0){
                    res[1] = "Ya";
                }
                if(nums != 0 && fracs == 0){
                    res[0] = "Ya";
                }
                if(nums != 0 && fracs != 0){
                    res[1] = "Ya";
                    res[0] = "Ya";
                }
            }
            for(int i=0;i<4;i++){
                System.out.print(res[i] + " ");
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
