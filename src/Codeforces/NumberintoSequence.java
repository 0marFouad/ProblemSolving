package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberintoSequence {


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

    public static long getSmallestDivisor(long n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return i;
            }
        }
        return n;
    }

    public static Long primeFactors(long n)
    {
        HashMap<Long,Integer> mp = new HashMap<>();
        ArrayList<Long> nums = new ArrayList<>();
        while (n%2==0)
        {
            if(!mp.containsKey(2l)){
                nums.add(2l);
            }
            mp.put(2l,mp.getOrDefault(2l,0)+1);
            n /= 2;
        }
        for (long i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0) {
                if(!mp.containsKey(i)){
                    nums.add(i);
                }
                mp.put(i,mp.getOrDefault(i,0)+1);
                n /= i;
            }
        }
        if (n > 2){
            if(!mp.containsKey(n)){
                nums.add(n);
            }
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        long mx = Long.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            mx = Math.max(mx,mp.get(nums.get(i)));
        }

        for(int i=0;i<nums.size();i++){
            if(mp.get(nums.get(i)) == mx){
                return nums.get(i);
            }
        }
        return 1l;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            long smallestDivisor = primeFactors(n);
            ArrayList<Long> res = new ArrayList<>();
            while(n%(smallestDivisor*smallestDivisor) == 0){
                res.add(smallestDivisor);
                n /= smallestDivisor;
            }
            res.add(n);
            System.out.println(res.size());
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i) + " ");
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