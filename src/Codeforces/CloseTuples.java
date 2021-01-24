package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CloseTuples {


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

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            sort(arr);
            long ans = 0;
            int j = 1;
            for(int i=0;i<n-2;i++){
                while(j<n-1 && arr[j]<=arr[i]+2){
                    j++;
                }
                if(arr[j] - arr[i] > 2){
                    j--;
                }
                if(j - i + 1 >= 3){
                    long nn = j-i;
                    ans += (((nn)*(nn-1))/2);
                }

            }
            System.out.println(ans);
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