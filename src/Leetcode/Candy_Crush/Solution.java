package Leetcode.Candy_Crush;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public static String candy_crush(String s){
        //Small Input
        if(s.length() < 3){
            return s;
        }

        //Scanning Stack
        Stack<Character> st = new Stack<>();
        char leftmost_char = s.charAt(0);
        char mid_char = s.charAt(1);
        char rightmost_char = s.charAt(2);

        //Variable for iterating through input string
        int i=0;

        //Keeping Memory of the previously removed characters
        HashSet<Character> removed_map = new HashSet<>();
        Stack<Character> removed_stack = new Stack<>();

        while(i < s.length()){
            st.push(s.charAt(i));
            if(st.size() >= 3){
                //Tracking our top 3 characters
                rightmost_char = st.pop();
                mid_char = st.pop();
                leftmost_char = st.peek();
                st.push(mid_char);
                st.push(rightmost_char);
            }
            if(st.size() >= 3){
                if(leftmost_char == mid_char && mid_char == rightmost_char){
                    //Removing characters
                    st.pop();
                    st.pop();
                    char top = st.pop();

                    //Handling More than consecutive 3s
                    while(i+1 < s.length() && s.charAt(i+1) == top){
                        i++;
                    }
                    removed_map.add(top);
                    removed_stack.add(top);
                    //Using the memory to avoid recurison
                    while(i+1 < s.length() && removed_map.contains(s.charAt(i+1))){
                        while(!removed_stack.empty() && removed_stack.peek() != s.charAt(i+1)){
                            removed_map.remove(removed_stack.pop());
                        }
                        i++;
                    }
                }else{
                    removed_map.clear();
                    removed_stack.clear();
                }
            }
            i++;
        }

        //Getting SolutionCompleteSearch out of the Stack
        StringBuilder res = new StringBuilder();
        while(!st.empty()){
            res.append(st.peek());
            st.pop();
        }
        return res.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(candy_crush("aaaaabbbccccccccva"));
    }
}
