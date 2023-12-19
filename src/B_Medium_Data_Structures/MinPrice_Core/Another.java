package B_Medium_Data_Structures.MinPrice_Core;

import java.util.Arrays;

public class Another {
    public static int minCost(int n, int k, int[][] plans) {
        int[][] dp = new int[n + 1][k + 1];
        int INF = Integer.MAX_VALUE / 2;

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int[] plan : plans) {
                    int startDay = plan[0];
                    int endDay = plan[1];
                    int coresAvailable = plan[2];
                    int costPerCore = plan[3];

                    if (j + coresAvailable <= k && i >= startDay && i <= endDay) {
                        dp[i][j + coresAvailable] = Math.min(dp[i][j + coresAvailable],
                                dp[i - 1][j] + coresAvailable * costPerCore);
                    }
                }
            }
        }

        int minCost = INF;
        for (int j = k; j <= k; j++) {
            minCost = Math.min(minCost, dp[n][j]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 7;
        int[][] plans = {{1, 3, 5, 2}, {1, 4, 5, 3}, {2, 5, 10, 1}};

        int result = minCost(n, k, plans);
        System.out.println("Minimum cost: " + result);
    }
}
