package DailyChallenge.October2020;

import java.util.Arrays;

public class NoOfLongestIncreasingSubsequence
{
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        if (l <= 1) {
            return l;
        }

        int[] lengths = new int[l];
        int[] counts = new int[l];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        int maxLen = 1;
        for (int j = 1; j < l; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    // Only interested in len-i if len-i is either > or == len-j
                    // or len-i + 1 == len-j
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                        maxLen = Math.max(maxLen, lengths[j]);
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < lengths.length; i++) {
            if (lengths[i] == maxLen) {
                result += counts[i];
            }
        }

        return result;
    }
}
