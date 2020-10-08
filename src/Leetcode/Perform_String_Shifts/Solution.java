package Leetcode.Perform_String_Shifts;

public class Solution {

    public static String stringShift(String s, int[][] shift) {
        int idx = 0;
        for(int i=0;i<shift.length;i++){
            int dir = shift[i][0];
            int dis = shift[i][1] % s.length();
            if(dir == 1){
                idx -= dis;
                if(idx < 0){
                    idx += s.length();
                }
            }else{
                idx += dis;
                idx = idx % s.length();
            }
        }
        String ans = "";
        for(int i=0;i<s.length();i++){
            ans += s.charAt(idx);
            idx++;
            idx = idx % s.length();
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "abcdefg";
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(stringShift(s,shift));
    }
}
