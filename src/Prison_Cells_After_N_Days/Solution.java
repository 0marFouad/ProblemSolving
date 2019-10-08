package Prison_Cells_After_N_Days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static int arrToNum(int[] cells){
        int result = 0;
        for(int i=1;i<cells.length-1;i++){
            result += cells[i] == 1 ? Math.pow(2,6-i) : 0;
        }
        return result;
    }

    public static int[] handleRepetition(ArrayList<Integer[]> prevForms,int N){
        return Arrays.stream(prevForms.get(N%prevForms.size())).mapToInt(Integer::intValue).toArray();
    }



    public static int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        ArrayList<Integer[]> prevForms = new ArrayList<>();
        int count = 0;
        int[] temp = cells.clone();
        while(N-- > 0) {
            for(int i=1;i<cells.length-1;i++){
                if(temp[i-1] == temp[i+1]){
                    cells[i] = 1;
                }else{
                    cells[i] = 0;
                }
            }
            cells[0] = 0;
            cells[cells.length-1] = 0;

            if(map.get(arrToNum(cells)) != null){
                return handleRepetition(prevForms,N);
            }
            map.put(arrToNum(cells), Arrays.stream(cells).boxed().toArray( Integer[]::new ));
            prevForms.add(Arrays.stream(cells).boxed().toArray( Integer[]::new ));


            boolean test = true;
            for(int i=0;i<cells.length;i++){
                test = test && (cells[i] == temp[i]);
            }
            if(test){
                return cells;
            }
            temp = cells.clone();
        }
        return cells;
    }

    public static void main(String[] args){
        int[] cells = {1,0,0,1,0,0,1,0};
        cells = prisonAfterNDays(cells,1000000000);
        for(int i=0;i<cells.length;i++){
            System.out.print(cells[i] + " ");
        }
    }
}
