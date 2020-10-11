package Codeforces.Edu96A;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main {

    public static int[] solve(int n){
        int[] res;
        for(int i=0;i<=334;i++){
            for(int j=0;j<=200;j++){
                for(int k=0;k<=143;k++){
                    if(3*i + 5*j + 7*k == n){
                        res = new int[3];
                        res[0] = i;
                        res[1] = j;
                        res[2] = k;
                        return res;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        MyScanner s = new MyScanner();
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int[] r = solve(n);
            if(r == null){
                System.out.println("-1");
                continue;
            }
            System.out.println(r[0] + " " + r[1] + " " + r[2]);
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
