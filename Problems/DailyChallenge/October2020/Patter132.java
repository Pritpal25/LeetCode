package DailyChallenge.October2020;

import java.util.ArrayList;
import java.util.List;

public class Patter132
{
    // O(n^3 solution)
    /*public boolean find132pattern(int[] nums) {
        int l = nums.length;

        if (l < 3) {
            return false;
        }

        boolean patternExists = false;

        for (int i = 0; i < l-2; i++) {
            for (int j = i+1; j < l-1; j++) {
                for(int k = j+1; k < l; k++) {
                    if ((nums[i] < nums[k]) && (nums[k] < nums[j])) {
                        patternExists = true;
                    }
                }
            }
        }

        return patternExists;
    }*/

    // Find rising slopes(i,j) and check number(k) in those slopes
    // Rising slopes will have the relation i < j and num[i] < num[j]
    // k will enforce the relation j < k and num[k] < num[j]

    public static boolean find132pattern(int[] nums) {
        int l = nums.length;
        if (l < 3) {
            return false;
        }

        List<int[]> rising_intervals = new ArrayList<>();
        int local_min = 0;
        boolean trend_est = false;  // if you dont have trend_est, you miss on the slope (3, 5) [3,5,0,3,4] input.
        for (int i = 1; i < l; i++) {
            if (nums[i] <= nums[local_min] && !trend_est) {
                local_min = i;
                continue;
            }

            trend_est = true;
            if (nums[i] < nums[i-1] && trend_est) {
                rising_intervals.add(new int[]{nums[local_min], nums[i-1]});
                local_min = i;
                trend_est = false;
            }

            for (int[] interval : rising_intervals) {
                if (interval[0] < nums[i] && nums[i] < interval[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,0,3,4};

        System.out.println(find132pattern(nums));
    }
}
