package Codeforces;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class AvoidingZero {

    public static Integer[] solvable(String[] arr){
        int tot = 0;
        Integer[] nums = new Integer[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
            tot += Integer.parseInt(arr[i]);
        }
        if(tot == 0){
            return null;
        }else{
            if(tot > 0){
                Arrays.sort(nums);
            }else{
                Arrays.sort(nums, Collections.reverseOrder());
            }
            return nums;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int sz = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            Integer[] nums = solvable(arr);
            if(nums == null){
                bw.write("NO\n");
                continue;
            }
            bw.write("YES\n");
            for(int j=nums.length-1;j>=0;j--){
                bw.write(nums[j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();

    }

}
