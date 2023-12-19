package B_Medium_Data_Structures.MinPrice_Core;

import java.util.*;

public class MinPriceCore {

    public static void main(String[] args) {
        int n = 5;
        int k = 7;
        int[][] plans = {{1, 3, 5, 2}, {1, 4, 5, 3}, {2, 5, 10, 1}};

        int result = calculate(n, k, plans);
        System.out.println("Minimum cost: " + result);
    }

    public static int calculate(int n, int k, int[][] plans){

        int[][] result = new int[n][k];
        int INF = Integer.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], INF);
        }

        for (int[] plan : plans){
            int start = plan[0];
            int end = plan[1];
            int core = plan[2];
            int price = plan[3];

            for (int i = 1; i <= n ; i++) {
                for (int j = 0; j < k; j++) {
                    if (i >= start && i <= end){
                        if (j < core){
                            result[i-1][j] = Math.min(price, result[i-1][j]);
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(result));

        return 1;
    }



}
