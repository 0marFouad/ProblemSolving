package Codeforces;
import java.util.*;

public class Main {

    public static int connect(StringBuilder num1, StringBuilder num2){
        if(num2.toString().equals("-1")){
            num2 = new StringBuilder();
        }
        return Integer.valueOf(num1.append(num2).toString());
    }

    public static int solution(int N) {
        int sign = 1;
        if(N<0){
            sign = -1;
            N = -N;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        int n1 = N;
        int n2 = -1;
        while(n1 > 0){
            if(n1%10 == 5){
                nums.add(connect(new StringBuilder((n1/10) + ""),new StringBuilder(n2 + "")));
            }
            if(n2 == -1){
                n2 = n1%10;
            }else{
                n2 = connect(new StringBuilder((n1%10)+""),new StringBuilder(n2+""));
            }
            n1 /= 10;
        }
        Collections.sort(nums);
        if(sign == -1){
            return sign * nums.get(0);
        }
        return nums.get(nums.size()-1);
    }

    public static void main(String[] args){
        System.out.println(solution(5195555));
    }
}
