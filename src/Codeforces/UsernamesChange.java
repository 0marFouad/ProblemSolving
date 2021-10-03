package Codeforces;

import java.util.ArrayList;
import java.util.List;

public class UsernamesChange {

    public static List<String> possibleChanges(List<String> usernames) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<usernames.size();i++){
            int num = 0;
            boolean added = false;
            for(int j=0;j<usernames.get(i).length();j++){
                if((int) usernames.get(i).charAt(j) < num){
                    res.add("YES");
                    added = true;
                    break;
                }
                num = (int) usernames.get(i).charAt(j);
            }
            if(!added){
                res.add("NO");
            }
        }
        return res;
    }

    public static void main(String[] args){
        List<String> un = new ArrayList<>();
        un.add("superhero");
        List<String> res = possibleChanges(un);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i));
        }
    }
}
