class Solution {
    static boolean isPrime(int n) {
        if(n == 1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static StringBuilder palindromize(StringBuilder str){
        if(str.length() <= 1){
            return str;
        }
        StringBuilder firstPart = new StringBuilder(str.substring(0,str.length()/2 + str.length()%2));
        for(int i=firstPart.length()-1-str.length()%2;i>=0;i--){
            firstPart.append(firstPart.charAt(i));
        }
        return firstPart;
    }

    public static StringBuilder repalindromize(StringBuilder str){
        if(str.length() <= 1){
            return str;
        }
        StringBuilder firstPart = new StringBuilder(str.substring(0,str.length()/2 + str.length()%2));
        firstPart = new StringBuilder((Integer.parseInt(firstPart.toString()) + 1) + "");
        for(int i=firstPart.length()-1-str.length()%2;i>=0;i--){
            firstPart.append(firstPart.charAt(i));
        }
        return firstPart;
    }

    public static int nextPalindrome(int n){
        StringBuilder str = new StringBuilder(n+"");
        StringBuilder newStr = palindromize(str);
        if(Integer.parseInt(newStr.toString()) >= Integer.parseInt(str.toString())){
            return Integer.parseInt(newStr.toString());
        }else{
            return Integer.parseInt(repalindromize(str).toString());
        }
    }



    public int primePalindrome(int N) {
        int i=nextPalindrome(N);
        while(true){
            if(isPrime(i)){
                return i;
            }
            i = nextPalindrome(i+1);
        }
    }
}