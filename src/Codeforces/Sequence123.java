package Codeforces;
import java.io.*;

public class Sequence123 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        int ones = 0;
        int twos = 0;
        int threes = 0;
        String[] arr = br.readLine().split(" ");
        for(int i=0;i<l;i++){
            if(arr[i].equals("1")){
                ones++;
            }else if(arr[i].equals("2")){
                twos++;
            }else{
                threes++;
            }
        }
        int res = l - Math.max(ones, Math.max(twos, threes));
        bw.write(res+"");
        bw.close();
        br.close();

    }

}
