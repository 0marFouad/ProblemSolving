package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {

    public static boolean searchNum(long num,int d){
        while(num != 0){
            if(num%10 == d){
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            int d = sc.nextInt();
            long[] arr = new long[q];
            for(int i=0;i<q;i++){
                arr[i] = sc.nextInt();
            }
            for(int i=0;i<q;i++){
                if(arr[i]/d >= 10){
                    System.out.println("YES");
                }else{
                    long cntD = arr[i]/d;
                    long rem = arr[i]%d;
                    long saved = 0;
                    boolean done = false;
                    for(int j=0;j<cntD;j++){
                        saved += d;
                        if(searchNum(saved+rem,d)){
                            done = true;
                        }
                    }
                    if(done){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
        }
    }



    public static int[] sort(int arr[]) {

        List<Integer> list = new ArrayList<>();
        for(int i:arr)
            list.add(i);
        Collections.sort(list);
        for(int i = 0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;

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