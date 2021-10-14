package Leetcode.ReverseWordsInString;

public class Solution {
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int startWord = -1;
        int endWord = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != ' '){
                if(startWord == -1){
                    startWord = i;
                }
                endWord = i;
            }else{
                if(startWord != -1){
                    while(startWord < endWord){
                        char temp = arr[startWord];
                        arr[startWord] = arr[endWord];
                        arr[endWord] = temp;
                        startWord++;
                        endWord--;
                    }
                }
                startWord = -1;
                endWord = -1;
            }
        }
        if(startWord != -1){
            while(startWord < endWord){
                char temp = arr[startWord];
                arr[startWord] = arr[endWord];
                arr[endWord] = temp;
                startWord++;
                endWord--;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
