package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistrictConnections {
    private static class Gang implements Comparable<Gang>{
        long id;
        ArrayList<Integer> districts;
        public Gang(long id){
            this.id = id;
            districts = new ArrayList<>();
        }

        @Override
        public int compareTo(Gang o) {
            return Integer.compare(districts.size(),o.districts.size());
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            ArrayList<Gang> gangs = new ArrayList<>();
            HashMap<Long,Gang> mp = new HashMap<>();
            boolean allSame = true;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLong();
                if(i>0){
                    if(arr[i-1] != arr[i]){
                        allSame = false;
                    }
                }
                if(mp.containsKey(arr[i])){
                    Gang g = mp.get(arr[i]);
                    g.districts.add(i);
                }else{
                    Gang g = new Gang(arr[i]);
                    g.districts.add(i);
                    gangs.add(g);
                    mp.put(arr[i],g);
                }
            }
            if(allSame || gangs.size() < 2){
                System.out.println("NO");
                continue;
            }
            Collections.sort(gangs);
            Gang first = gangs.get(0);
            System.out.println("YES");
            for(int i=1;i<gangs.size();i++){
                Gang second = gangs.get(i);
                for(int j=0;j<second.districts.size();j++){
                    int from = first.districts.get(0)+1;
                    int to = second.districts.get(j)+1;
                    System.out.println(from + " " + to);
                }
            }
            for(int i=1;i<first.districts.size();i++){
                int from = first.districts.get(i) + 1;
                int to = gangs.get(1).districts.get(0) + 1;
                System.out.println(from + " " + to);
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


