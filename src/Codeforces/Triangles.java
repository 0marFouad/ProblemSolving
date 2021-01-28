package Codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Triangles {

    public static class point implements Comparable<point>{
        char c;
        int i;
        int j;
        public point(char c,int i,int j){
            this.c = c;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(point o) {
            return Integer.compare(o.i,this.i);
        }
    }

    public static void main(String[] args){
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            char[][] arr = new char[n][n];
            HashMap<Character,ArrayList<point>> mpX = new HashMap<>();
            HashMap<Character,ArrayList<point>> mpY = new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextLine().toCharArray();
                for(int j=0;j<n;j++){
                    if(mpX.containsKey(arr[i][j])){
                        mpX.get(arr[i][j]).add(new point(arr[i][j],i,j));
                        mpY.get(arr[i][j]).add(new point(arr[i][j],j,i));
                    }else{
                        ArrayList<point> x = new ArrayList<>();
                        x.add(new point(arr[i][j],i,j));
                        mpX.put(arr[i][j],x);

                        ArrayList<point> y = new ArrayList<>();
                        y.add(new point(arr[i][j],j,i));
                        mpY.put(arr[i][j],y);
                    }


                }
            }
            for(char i='0';i<='9';i++){
                if(mpX.containsKey(i)){
                    Collections.sort(mpX.get(i));
                }
                if(mpY.containsKey(i)){
                    Collections.sort(mpY.get(i));
                }
            }

            int[] res = new int[10];
            for(int i=0;i<10;i++){
                char cur = (char)('0' + i);
                if(!mpX.containsKey(cur)){
                    continue;
                }
                //X test
                int fromX = mpX.get(cur).get(0).i;
                int fromY = mpX.get(cur).get(0).j;

                int toX = mpX.get(cur).get(mpX.get(cur).size()-1).i;
                int toY = mpX.get(cur).get(mpX.get(cur).size()-1).j;

                int diffx = toX - fromX;
                int diffy1 = Math.max(n-1 - fromY, fromY - 0);
                int diffy2 = Math.max(n-1 - toY, toY - 0);
                int diffy = Math.max(diffy1,diffy2);

                int area = Math.abs(diffx*diffy);


                //X test
                fromX = mpY.get(cur).get(0).i;
                fromY = mpY.get(cur).get(0).j;

                toX = mpY.get(cur).get(mpY.get(cur).size()-1).i;
                toY = mpY.get(cur).get(mpY.get(cur).size()-1).j;

                diffx = toX - fromX;
                diffy1 = Math.max(n-1 - fromY, fromY - 0);
                diffy2 = Math.max(n-1 - toY, toY - 0);
                diffy = Math.max(diffy1,diffy2);

                area = Math.max(area,Math.abs(diffx*diffy));

                res[i] = area;





            }

            for(int i=0;i<10;i++){
                System.out.print(res[i]+" ");
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