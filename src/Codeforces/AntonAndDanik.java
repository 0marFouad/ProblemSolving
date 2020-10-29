package Codeforces;
import java.io.*;

public class AntonAndDanik {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        String s = br.readLine();
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                res++;
            }else{
                res--;
            }
        }
        if(res > 0){
            bw.write("Anton");
        }else if(res < 0){
            bw.write("Danik");
        }else{
            bw.write("Friendship");
        }

        bw.close();
        br.close();

    }

}
