package DailyChallenge.November2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nov18_MergeIntervals
{
    public int[][] merge(int[][] intervals) {
        int l = intervals.length;
        if (l == 1) {
            return intervals;
        }

        Arrays.sort(intervals, ((a, b) -> Integer.compare(a[0], b[0])));

        List<int[]> temp = new ArrayList<>();
        int i = 0;

        while(i < l) {
            int start = intervals[i][0];
            int max = intervals[i][1];
            int j = i+1;

            while(j < l) {
                if (intervals[j][0] <= max) {
                    max = Math.max(max, intervals[j][1]);
                    j++;
                } else {
                    break;
                }
            }

            temp.add(new int[]{start, max});

            i = j;
        }

        // For conversion from list to array, declare the type of array you want the conversion
        // into and then do the below. This is required when you need to return something as
        // array but the size of the array is unknown
        int[][] result  = new int[temp.size()][2];
        result = temp.toArray(result);

        return result;
    }
}
