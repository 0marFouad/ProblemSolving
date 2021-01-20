package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayDestruction {

    static class Number implements Comparable<Number>{
        int num;
        int count;
        Number(int num,int count){
            this.num = num;
            this.count = count;
        }

        public void dec(){
            this.count--;
        }
        public void inc(){
            this.count++;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(o.num,this.num);
        }
    }

    static PriorityQueue<Number> pq;
    static HashMap<Integer, Number> mp;

    public static ArrayList<Integer> solve(int toBeFormed, ArrayList<Integer> res){
        if(pq.isEmpty()){
            return res;
        }


        Number largest;
        do{
            largest = pq.poll();
        }while(largest.count <= 0 && !pq.isEmpty());

        if((largest != null && largest.count == 0) || largest == null){
            return res;
        }

        largest.dec();
        if(mp.containsKey(toBeFormed - largest.num) && mp.get(toBeFormed - largest.num).count > 0){
            if(largest.count > 0){
                pq.add(largest);
            }
            mp.get(toBeFormed - largest.num).dec();
            res.add(largest.num);
            res.add(toBeFormed - largest.num);
            return solve(largest.num,res);
        }else{
            largest.inc();
            return null;
        }

    }


    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = 2*sc.nextInt();
            int[] arr = new int[n];
            mp = new HashMap<>();
            pq = new PriorityQueue<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(mp.containsKey(arr[i])){
                    mp.get(arr[i]).inc();
                }else{
                    Number num = new Number(arr[i],1);
                    mp.put(arr[i],num);
                    pq.add(num);
                }
            }
            Arrays.sort(arr);
            boolean solved = false;
            for(int i=0;i<n-1;i++){
                ArrayList<Integer> res = solve(arr[i] + arr[n-1], new ArrayList<>());

                if(res != null){
                    System.out.println("YES");
                    System.out.println(res.get(0) + res.get(1));
                    for(int j=0;j<res.size();j+=2){
                        System.out.println(res.get(j) + " " + res.get(j+1));
                    }
                    solved = true;
                    break;
                }
                mp = new HashMap<>();
                pq = new PriorityQueue<>();
                for(int ii=0;ii<n;ii++){
                    if(mp.containsKey(arr[ii])){
                        mp.get(arr[ii]).inc();
                    }else{
                        Number num = new Number(arr[ii],1);
                        mp.put(arr[ii],num);
                        pq.add(num);
                    }
                }
            }
            if(!solved){
                System.out.println("NO");
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
