package Codeforces;

import java.util.ArrayList;
import java.util.List;

public class HotelConstruction {

    public static int numberOfWays(List<List<Integer>> roads) {
        int nodes = roads.size() + 1;
        int[][] dist = new int[nodes+1][nodes+1];
        for(int i=0;i<=nodes;i++){
            for(int j=0;j<=nodes;j++){
                dist[i][j] = 9999;
            }
        }
        for(int i=0;i<roads.size();i++){
            int first = roads.get(i).get(0);
            int sec = roads.get(i).get(1);
            dist[first][sec] = 1;
            dist[sec][first] = 1;
        }
        for (int k = 1; k <= nodes; k++)
        {
            for (int i = 1; i <= nodes; i++)
            {
                for (int j = 1; j <= nodes; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int i=1;i<=nodes;i++){
            for(int j=1;j<=nodes;j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        int ans = 0;
        for(int i=1;i<=nodes;i++){
            for(int j=i+1;j<=nodes;j++){
                for(int k=j+1;k<=nodes;k++){
                    if(i==j||j==k||i==k){
                        continue;
                    }
                    if(dist[i][j] == dist[i][k] && dist[i][j] == dist[j][k]){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args){
        List<List<Integer>> roads = new ArrayList<>();
        List<Integer> road1 = new ArrayList<>();
        road1.add(1);
        road1.add(2);

        List<Integer> road2 = new ArrayList<>();
        road2.add(2);
        road2.add(5);

        List<Integer> road3 = new ArrayList<>();
        road3.add(3);
        road3.add(4);

        List<Integer> road4 = new ArrayList<>();
        road4.add(4);
        road4.add(5);

        List<Integer> road5 = new ArrayList<>();
        road5.add(5);
        road5.add(6);

        List<Integer> road6 = new ArrayList<>();
        road6.add(7);
        road6.add(6);

        roads.add(road1);
        roads.add(road6);
        roads.add(road5);
        roads.add(road4);
        roads.add(road3);
        roads.add(road2);

        System.out.println(numberOfWays(roads));

    }

}
