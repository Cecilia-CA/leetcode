package leetcode.test;

import java.util.HashSet;

/**
 * Leetcode 1647. Minimum Deletions to Make Character Frequencies Unique
 *
 * Programmer: Cecilia
 * Date: Apr 24, 2021
 * Success
 * Details
 * Runtime: 15 ms, faster than 58.70% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
 * Memory Usage: 39.3 MB, less than 91.68% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
 */

public class L1647_Minimum_Deletions_Char_Unique {
    public int minDeletions(String s) {
        int count = 0;
        int curChar = 0;
        int[] freqArr = new int[26];
        HashSet freqHash = new HashSet<Integer>();

        for (int i = 0; i < s.length(); i++) {
            curChar = s.charAt(i) - 'a';
            freqArr[curChar] = freqArr[curChar] + 1;
        }

        for (int i = 0; i < freqArr.length; i++) {
            curChar = freqArr[i];
            while (freqHash.contains(curChar) || curChar < 0) {
                count++;
                curChar--;
            }
            if (curChar > 0)
                freqHash.add(curChar);
        }
        return count;
    }

    public static void main(String[] args) {
        L1647_Minimum_Deletions_Char_Unique l1647_Minimum_Deletions_Char_Unique = new L1647_Minimum_Deletions_Char_Unique();

        System.out.println(l1647_Minimum_Deletions_Char_Unique.minDeletions("aaabbbccc"));
    }
}
