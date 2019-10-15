package Count_Primes;

public class Solution {

    public static int countPrimes(int n) {
        int[] isComposite = new int[n+1];
        isComposite[1] = 1;
        for(int i=2;i<=n;i++){
            if(isComposite[i]==0){
                for(int j=2*i;j<=n;j+=i){
                    isComposite[j] = 1;
                }
            }
        }
        int result = 0;
        for(int i=1;i<n;i++){
            if(isComposite[i] == 0){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(countPrimes(10));
    }

}
