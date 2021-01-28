package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] d = new long[2*n];
            long sum = Long.MAX_VALUE;
            boolean can = true;
            HashSet<Long> rem = new HashSet<>();
            ArrayList<Long> nums = new ArrayList<>();
            int test = 0;
            for(int i=0;i<2*n;i++){
                d[i] = sc.nextLong();
                if(!rem.contains(d[i])){
                    test++;
                    nums.add(d[i]);
                    rem.add(d[i]);
                }
                if(d[i]%2==1 || d[i]<=0){
                    can = false;
                }
            }
            if(!can || test != n){
                System.out.println("NO");
                continue;
            }
            Collections.sort(nums);
            sum = nums.get(0)/2;

            ArrayList<Long> diffs = new ArrayList<>();
            long acc = 0;
            long sum2 = sum;
            long div = 2;
            long saved = 0;
            for(int i=0;i<nums.size()-1;i++){
                long df = nums.get(i+1) - nums.get(i);
                diffs.add(df);
                if(df <= 0 || df%div != 0){
                    sum2 = -1;
                    break;
                }
                acc += (df/div);
                sum2 -= (acc);
                div+=2;
            }
            if(sum2 <= 0 || sum2%nums.size() != 0){
                System.out.println("NO");
            }else{
                System.out.println("YES");
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