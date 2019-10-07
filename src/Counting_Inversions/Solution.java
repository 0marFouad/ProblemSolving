package Counting_Inversions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Solution {

    public static ArrayList<Integer> CombineWithInversion(ArrayList<Integer> firstArray,ArrayList<Integer> secondPart){
        int ptr1 = 0, ptr2 = 0;
        ArrayList<Integer> MergeArrays = new ArrayList<>();
        int inversions = 0;
        while(ptr1 < firstArray.size()-1 && ptr2 < secondPart.size() - 1){
            if(firstArray.get(ptr1) <= secondPart.get(ptr2)){
                MergeArrays.add(firstArray.get(ptr1));
                ptr1++;
            }else{
                inversions += ptr2+1;
                MergeArrays.add(secondPart.get(ptr2));
                ptr2++;
            }
        }
        if(ptr2 == secondPart.size()-1){
            inversions += (firstArray.size() - ptr1 - 2)*(secondPart.size()-1);
        }
        while(ptr1 < firstArray.size()-1){
            MergeArrays.add(firstArray.get(ptr1));
            ptr1++;
        }
        while(ptr2 < secondPart.size()-1){
            MergeArrays.add(secondPart.get(ptr2));
            ptr2++;
        }

        inversions += firstArray.get(firstArray.size()-1);
        inversions += secondPart.get(secondPart.size()-1);
        MergeArrays.add(inversions);
        return MergeArrays;
    }

    public static ArrayList<Integer> SortAndCount(ArrayList<Integer> arr,int l,int r){
        if(l==r){
            ArrayList<Integer> toRet = new ArrayList<>();
            toRet.add(arr.get(l));
            toRet.add(0);
            return  toRet;
        }
        int mid = l + (r-l)/2;
        ArrayList<Integer> firstHalf = SortAndCount(arr,l,mid);
        ArrayList<Integer> secondHalf = SortAndCount(arr,mid+1,r);
        return CombineWithInversion(firstHalf,secondHalf);
    }

    public static ArrayList<Integer> readFile(String filename){
        ArrayList<Integer> ret = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/home/fo2sh/Desktop/ProblemSolving/src/Counting_Inversions/" + filename));
            String line;
            while ((line = br.readLine()) != null) {
                ret.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        //ArrayList<Integer> numbers = readFile("numbers.txt");
        ArrayList<Integer> num = new ArrayList<>();
        num.add(6);
        num.add(5);
        num.add(4);
        num.add(3);
        num.add(2);
        num.add(1);
        ArrayList<Integer> ans = SortAndCount(num,0,num.size()-1);
        System.out.print(ans.get(ans.size()-1));
    }
}
