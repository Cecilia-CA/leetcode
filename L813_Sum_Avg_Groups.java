package leetcode.test;

/**
 * Leetcode 813. Largest Sum of Averages
 * Difficulty: Medium
 *
 * Programmer: Cecilia
 * Date: Apr 21, 2021
 * Runtime: 7 ms, faster than 59.95% of Java online submissions for Largest Sum of Averages.
 * Memory Usage: 37 MB, less than 52.99% of Java online submissions for Largest Sum of Averages.
 */

public class L813_Sum_Avg_Groups {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] memo = new double[K+1][n];
        double sum = 0.0;
        if (K > n)
            return 0.0;

        memo[0][0] = A[0];
        memo[1][0] = A[0];

        // for k = 1
        for (int i=0; i < n; i++) {
            sum += A[i];
            memo[1][i] = sum / (i+1);
        }

        for (int k=2; k <= K; k++) {
            for (int i=0; i < n; i++) {
                sum = 0;
                for (int j=i; j >= k-1; j--) {
                    // cur max = max of ((current location) or (previous left group + avg right group) separate by j)
                    sum += A[j];

                    if (j-1 >= 0)
                        //memo[k][i] = Math.max(memo[k][i], memo[k - 1][j-1] + avg[i-j+1][i]);
                        memo[k][i] = Math.max(memo[k][i], memo[k - 1][j-1] + sum / (i-j+1));
                }
            }
        }

        return memo[K][n-1];
    }

    public static void main (String[] args) {
        L813_Sum_Avg_Groups l813_SumOfAvgOfGroups = new L813_Sum_Avg_Groups();
        System.out.println(l813_SumOfAvgOfGroups.largestSumOfAverages(new int[] {1, 2, 3}, 2));
        System.out.println(l813_SumOfAvgOfGroups.largestSumOfAverages(new int[] {3, 2, 1}, 2));
        System.out.println(l813_SumOfAvgOfGroups.largestSumOfAverages(new int[] {3, 2, 1}, 3));
        System.out.println(l813_SumOfAvgOfGroups.largestSumOfAverages(new int[] {9, 1, 2, 3, 9}, 3));

    }
}
