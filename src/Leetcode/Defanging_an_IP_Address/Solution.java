package Leetcode.Defanging_an_IP_Address;

public class Solution {
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }


    public static void main(String[] args){
        String ret = defangIPaddr("192.168.1.1");
        System.out.print(ret);
    }
}
