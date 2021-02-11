package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class BinaryTable {

    public static class Operation{
        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;
        public Operation(int x1,int y1,int x2,int y2,int x3,int y3){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }
    }


    public static ArrayList<Operation> countOps(char[][] arr,int offsetR,int offsetC,int r,int c){
        int ones = 0;
        if(r-offsetR < 2){
            offsetR--;
        }
        if(c-offsetC < 2){
            offsetC--;
        }
        for(int i=0;i<Math.min(2,r-offsetR);i++){
            for(int j=0;j<Math.min(2,c-offsetC);j++){
                ones += ('1' - arr[i+offsetR][j+offsetC]);
            }
        }
        ones = 4 - ones;
        ArrayList<Operation> ret = new ArrayList<>();
        if(ones == 0){
            return ret;
        }
        if(ones%2 == 1){
            for(int i=0;i<Math.min(2,r-offsetR);i++){
                for(int j=0;j<Math.min(2,c-offsetC);j++){
                    if(arr[i+offsetR][j+offsetC] == '0'){
                        if(i+1 == 1 && j+1 == 1){
                            Operation o1 = new Operation(2 + offsetR,2 + offsetC,1 + offsetR,2 + offsetC,2 + offsetR,1 + offsetC);
                            ret.add(o1);
                        }
                        if(i+1 == 2 && j+1 == 1){
                            Operation o1 = new Operation(1 + offsetR,1 + offsetC, 1 + offsetR,2 + offsetC,2 + offsetR,2 + offsetC);
                            ret.add(o1);
                        }
                        if(i+1 == 1 && j+1 == 2){
                            Operation o1 = new Operation(2 + offsetR,2 + offsetC,1 + offsetR,1 + offsetC,2 + offsetR,1 + offsetC);
                            ret.add(o1);
                        }
                        if(i+1 == 2 && j+1 == 2){
                            Operation o1 = new Operation(1 + offsetR,1 + offsetC,1 + offsetR,2 + offsetC, 2 + offsetR,1 + offsetC);
                            ret.add(o1);
                        }
                    }
                    arr[i+offsetR][j+offsetC] = '0';
                }
            }
            return ret;
        }

        for(int i=0;i<Math.min(2,r-offsetR);i++){
            for(int j=0;j<Math.min(2,c-offsetC);j++){
                if(arr[i+offsetR][j+offsetC] == '1'){
                    if(i+1 == 1 && j+1 == 1){
                        Operation o1 = new Operation(2 + offsetR,2 + offsetC,1 + offsetR,2 + offsetC,2 + offsetR,1 + offsetC);
                        ret.add(o1);
                    }
                    if(i+1 == 2 && j+1 == 1){
                        Operation o1 = new Operation(1 + offsetR,1 + offsetC, 1 + offsetR,2 + offsetC,2 + offsetR,2 + offsetC);
                        ret.add(o1);
                    }
                    if(i+1 == 1 && j+1 == 2){
                        Operation o1 = new Operation(2 + offsetR,2 + offsetC,1 + offsetR,1 + offsetC,2 + offsetR,1 + offsetC);
                        ret.add(o1);
                    }
                    if(i+1 == 2 && j+1 == 2){
                        Operation o1 = new Operation(1 + offsetR,1 + offsetC,1 + offsetR,2 + offsetC, 2 + offsetR,1 + offsetC);
                        ret.add(o1);
                    }
                }
                arr[i+offsetR][j+offsetC] = '0';
            }
        }
        return ret;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLine().toCharArray();
            }
            ArrayList<ArrayList<Operation>> res = new ArrayList<>();
            int tot = 0;
            for(int i=0;i<n;i+=2){
                for(int j=0;j<m;j+=2){
                    ArrayList<Operation> r = countOps(arr,i,j,n,m);
                    tot += r.size();
                    res.add(r);
                }
            }
            System.out.println(tot);
            for(int i=0;i<res.size();i++){
                ArrayList<Operation> r = res.get(i);
                for(int k=0;k<r.size();k++){
                    System.out.println(r.get(k).x1 + " " + r.get(k).y1 + " " + r.get(k).x2 + " " + r.get(k).y2 + " " + r.get(k).x3 + " " + r.get(k).y3);
                }
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
