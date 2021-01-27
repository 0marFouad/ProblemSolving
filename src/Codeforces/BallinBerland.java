package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BallinBerland {

    public static class Pair implements Comparable<Pair>{
        int i;
        int j;
        public Pair(int i,int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.i,o.i);
        }
    }

    public static int binarySearch(ArrayList<Integer> arr, int startIdx){
        int l = 0;
        int r = arr.size()-1;
        while(r-l>1){
            int mid = l + (r-l)/2;
            if(arr.get(mid) >= startIdx){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        if(arr.get(r) < startIdx){
            return arr.size() - r - 1;
        }
        if(arr.get(r) == startIdx){
            return arr.size() - r;
        }
        if(arr.get(r) > startIdx && arr.get(l) < startIdx){
            return arr.size() - r;
        }
        return arr.size() - l;

    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();
            HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
            HashMap<Integer,Integer> lastIdx = new HashMap<>();
            for(int i=0;i<k;i++){
                Pair x = new Pair(sc.nextInt(),0);
                pairs.add(x);
            }
            for(int i=0;i<k;i++){
                pairs.get(i).j = sc.nextInt();
            }
            Collections.sort(pairs);
            for(int i=0;i<k;i++){
                if(mp.containsKey(pairs.get(i).j)){
                    mp.get(pairs.get(i).j).add(i);
                }else{
                    ArrayList<Integer> nnew = new ArrayList<>();
                    nnew.add(i);
                    mp.put(pairs.get(i).j,nnew);
                }
            }
            for(int i=0;i<pairs.size();i++){
                lastIdx.put(pairs.get(i).i,i);
            }

            long ans = 0;
            for(int i=0;i<pairs.size();i++){
                int from = pairs.get(i).i;
                int to = pairs.get(i).j;
                int lastidx = lastIdx.get(from)+1;
                if(lastidx >= pairs.size()){
                    continue;
                }
                ans += (pairs.size() - lastidx);
                ans -= binarySearch(mp.get(to),lastidx);

            }
            System.out.println(ans);
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