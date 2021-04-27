package leetcode.test;

/**
 * 1578. Minimum Deletion Cost to Avoid Repeating Letters
 * Difficulty: Medium
 *
 * Programmer: Cecilia
 * Date: Apr 26, 2021
 * Success
 * Details
 * Runtime: 8 ms, faster than 52.18% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
 * Memory Usage: 47.9 MB, less than 91.44% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
 *
 */

public class L1578_Minimum_Deletion_Cost {
    public int minCost(String s, int[] cost) {
        int size = cost.length;
        int[] memo = new int[size];
        char prevChar;
        int stayCharIndex = -1;

        memo[0] = 0;
        prevChar = s.charAt(0);

        for (int i = 1; i < size; i++) {
            if (prevChar == s.charAt(i)) {
                if (stayCharIndex == -1) {
                    memo[i] = memo[i-1] + Math.min(cost[i], cost[i-1]);
                    stayCharIndex = cost[i] > cost[i-1]?i:i-1;
                }
                else {
                    memo[i] = memo[i-1] + Math.min(cost[stayCharIndex], cost[i]);
                    stayCharIndex = cost[i] > cost[stayCharIndex]?i:stayCharIndex;
                }
            }
            else {
                memo[i] = memo[i-1];
                stayCharIndex = -1;
            }

            prevChar = s.charAt(i);
        }
        return memo[size-1];
    }

    public static void main(String[] args) {
        L1578_Minimum_Deletion_Cost l1578_Minimum_Deletion_Cost = new L1578_Minimum_Deletion_Cost();

        System.out.println(l1578_Minimum_Deletion_Cost.minCost("bbbaaa", new int[] {4,9,3,8,8,9}));
        System.out.println(l1578_Minimum_Deletion_Cost.minCost("abaaaaaa", new int[] {2,2,1,2,5234,3,2,6}));
        System.out.println(l1578_Minimum_Deletion_Cost.minCost("abaac", new int[] {1,2,3,4,5}));
    }
}
