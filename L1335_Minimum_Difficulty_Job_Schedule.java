package leetcode.test;

/**
 * Leetcode 1335. Minimum Difficulty of a Job Schedule
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.
 *
 * Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 *
 * Success
 * Runtime: 9 ms, faster than 58.44% of Java online submissions for Minimum Difficulty of a Job Schedule.
 * Memory Usage: 36.3 MB, less than 96.91% of Java online submissions for Minimum Difficulty of a Job Schedule.
 * Programmer: Cecilia
 */

public class L1335_Minimum_Difficulty_Job_Schedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[] jobDiff = new int[n+1];
        int[][] memo = new int[d+1][n+1];
        int curMax = 0;

        if (d > n)
            return -1;

        // add a 0 at the beginning of array to avoid index out of bound
        for (int i = 0; i < n; i++)
            jobDiff[i+1] = jobDifficulty[i];

        for (int days = 1; days <= d; days++) {
            for (int i = 1; i <= n; i++) {
                if (days == 1)
                    memo[days][i] = Math.max(memo[days][i-1], jobDiff[i]);
                else {
                    curMax = 0;
                    for (int j = i; j >= days; j--) {
                        curMax = Math.max(curMax, jobDiff[j]);
                        if (memo[days][i] == 0)
                            memo[days][i] = memo[days-1][j-1] + curMax;
                        memo[days][i] = Math.min(memo[days][i], memo[days-1][j-1] + curMax);
                    }
                }
            }
        }

        return memo[d][n];
    }

    public static void main(String[] args) {
        L1335_Minimum_Difficulty_Job_Schedule l1335_Minimum_Difficulty_Job_Schedule = new L1335_Minimum_Difficulty_Job_Schedule();

        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {7,1,7,1,7,1}, 3));
        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {11,111,22,222,33,333,44,444}, 6));
        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {1, 1, 1}, 3));

        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {6, 5, 4, 3, 2, 1}, 2));
        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {9, 9, 9}, 4));
        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {1, 1, 1}, 1));
        System.out.println(l1335_Minimum_Difficulty_Job_Schedule.minDifficulty(new  int[] {1, 1, 1}, 2));

    }
}
