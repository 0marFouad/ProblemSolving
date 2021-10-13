package Leetcode.Encryption;

public class solution {
    public static String encryption(String s) {
        s = s.replaceAll("\\s","");
        double num = Math.sqrt(s.length());
        int r = (int)Math.floor(num);
        int c = (int)Math.ceil(num);
        while(r*c < s.length()){
            r++;
        }
        int k = 0;
        char[][] arr = new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c && k < s.length();j++){
                arr[i][j] = s.charAt(k);
                k++;
            }
        }
        int l = r*c - s.length();
        for(int i=c-1;i>=c-l;i--){
            arr[r-1][i] = '-';
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                if(arr[j][i] == '-'){
                    continue;
                }
                sb.append(arr[j][i]);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "     OM  aRR a s";
        System.out.print(encryption(s));
    }
}
