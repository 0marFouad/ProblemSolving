package Solve_the_Equation;

public class Solution {
    public static String solveEquation(String equation) {
        int leftAdded = 0;
        int leftMult = 0;
        int rightAdded = 0;
        int rightMult = 0;
        String[] eSides = equation.split("=");
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<eSides[0].length();i++){
            if(eSides[0].charAt(i) != '+' && eSides[0].charAt(i) != '-'){
                str.append(eSides[0].charAt(i));
            }else{

                String exp = str.toString();
                str = new StringBuilder();
                if(exp.charAt(exp.length()-1) == 'x'){
                    String num = exp.substring(0,exp.length()-1);
                    if(num.length() == 0){
                        leftMult += 1;
                    }else{
                        leftMult += Integer.parseInt(num);
                    }
                }else{
                    leftAdded = Integer.parseInt(exp);
                }
            }
        }
        str = new StringBuilder();
        for(int i = 0;i<eSides[1].length();i++){
            if(eSides[1].charAt(i) != '+' && eSides[1].charAt(i) != '-'){
                str.append(eSides[0].charAt(i));
            }else{

                String exp = str.toString();
                str = new StringBuilder();
                if(exp.charAt(exp.length()-1) == 'x'){
                    String num = exp.substring(0,exp.length()-1);
                    if(num.length() == 0){
                        rightMult += 1;
                    }else{
                        rightMult += Integer.parseInt(num);
                    }
                }else{
                    rightAdded = Integer.parseInt(exp);
                }
            }
        }

        int Xs = leftMult - rightMult;
        int Ys = rightAdded - leftAdded;
        if(Xs == 0 && Ys == 0){
            return "Infinite solutions";
        }
        if(Xs == 0 || Ys == 0){
            return "No solution";
        }
        int fin = Ys/Xs;
        return "x="+fin;
    }

    public static void main(String[] args){
        System.out.println(solveEquation("x+5=2x-10"));
    }

}
