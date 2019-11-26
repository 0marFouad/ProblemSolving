package Merge_Sorted_Array;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        int f = 0;
        int s = 0;
        int[] res = new int[nums1.length];
        int i=0;
        while(f < m && s < n){
            if(nums1[f] <= nums2[s]){
                res[i] = nums1[f];
                i++;
                f++;
            }else{
                res[i] = nums2[s];
                s++;
                i++;
            }
        }
        while(f<m){
            res[i] = nums1[f];
            f++;
            i++;
        }
        while(s<n){
            res[i] = nums2[s];
            s++;
            i++;
        }
        for(int ii=0;ii<nums1.length;ii++){
            nums1[ii] = res[ii];
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
    }

}
