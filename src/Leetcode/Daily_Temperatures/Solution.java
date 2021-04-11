package Leetcode.Daily_Temperatures;

import java.util.Stack;

public class Solution {
    public static int[] dailyTemperatures(int[] T) {
        int[] map = new int[101];
        int n = T.length;
        map[T[n-1]] = n-1;
        int[] res = new int[n];
        res[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                res[i] = 0;
            }else{
                while(!st.isEmpty() && T[i] >= T[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res[i] = 0;
                }else{
                    res[i] = st.peek() - i;
                }
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temps);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
