package Sum_of_Two_Integers;

public class Solution {
    public static int getSum(int a, int b) {
        int result = 0;
        int counter = 0;
        int rem = 0;
        while(counter < 32){
            int first = a&1;
            int second = b&1;
            a = a>>1;
            b = b>>1;
            int r = rem^first^second;
            if(rem == first && first == second){
                rem = r;
            }else{
                rem = 1 - r;
            }
            r = r << counter;
            result = result | r;
            counter++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getSum(-,2));
    }
}
