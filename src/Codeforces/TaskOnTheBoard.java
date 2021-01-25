package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskOnTheBoard {

    public static int countZeros(int[] arr){
        int res = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            String str = sc.nextLine();
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }

            int[] cnt = new int[26];
            for(int i=0;i< str.length();i++){
                cnt[str.charAt(i) - 'a']++;
            }

            int done = 0;
            char[] word = new char[n];
            while(done < n){
                int zeros = countZeros(arr);
                char chosenLetter = '-';
                for(int i=25;i>=0;i--){
                    if(cnt[i] >= zeros){
                        chosenLetter = (char)((int)'a' + i);
                        for(int k=i;k<26;k++){
                            cnt[k] = 0;
                        }
                        break;
                    }
                }
                int z = 0;
                for(int i=0;i<n&&z<zeros;i++){
                    if(arr[i] == 0){
                        word[i] = chosenLetter;
                        for(int j=0;j<i;j++){
                            if(arr[j] != 0 && arr[j] != Integer.MAX_VALUE){
                                arr[j] -= Math.abs(i - j);
                            }
                        }
                        for(int j=i+1;j<n;j++){
                            if(arr[j] != 0 && arr[j] != Integer.MAX_VALUE){
                                arr[j] -= Math.abs(i - j);
                            }
                        }
                        z++;
                        arr[i] = Integer.MAX_VALUE;
                    }
                }
                done += zeros;
            }

            for(int i=0;i<word.length;i++){
                System.out.print(word[i]);
            }
            System.out.println();










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