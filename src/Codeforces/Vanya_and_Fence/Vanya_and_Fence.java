package Codeforces.Vanya_and_Fence;


import java.io.*;

public class Vanya_and_Fence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        String[] parts = line.split(" ");
        int n,h;
        n = Integer.parseInt(parts[0]);
        h = Integer.parseInt(parts[1]);
        line = br.readLine();
        parts = line.split(" ");
        int y;
        int ans = 0;
        for(int i=0;i<n;i++){
            y = Integer.parseInt(parts[i]);
            if(y>h){
                ans+=2;
            }else{
                ans++;
            }
        }
        bw.write(ans+"");
        bw.close();
        br.close();
    }
}
