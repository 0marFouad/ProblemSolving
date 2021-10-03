package Codeforces;

public class DecryptPassword {
    public static String decryptPassword(String s) {
        StringBuilder sb = new StringBuilder();
        int crnt = 0;
        for(int i=s.length()-1;i>=crnt;i--){
            if(s.charAt(i) == '0'){
                sb.append(s.charAt(crnt));
                crnt++;
            }else if(s.charAt(i) == '*'){
                sb.append(s.charAt(i-2));
                sb.append(s.charAt(i-1));
                i-=2;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        System.out.print(decryptPassword("43Ah*ck0rr0nk"));
    }
}
