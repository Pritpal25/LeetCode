package DailyChallenge.November2020;

import java.util.Arrays;

public class Nov6_SmallestDivisorGivenAThreshold
{
    public static int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int l_sum = Arrays.stream(nums).sum();

        int r = Arrays.stream(nums).max().getAsInt();
        int r_sum = nums.length;

        //int minDiv = Integer.MAX_VALUE;

        while (l <= r) {
            // To prevent overflow in java, dont do (l+r)/2
            int mid = l + (r-l)/2;
            int mid_sum = result(nums, mid);

            if (mid_sum == threshold) {
                // mid is a possible sol;
                // now search is the space, [l -> mid -1]
                r = mid - 1;
                //minDiv = Math.min(minDiv, mid);
            } else if (mid_sum > threshold) {
                // no element till mid can be the solution
                // Search in [mid + 1, r]
                l = mid + 1;
            } else {
                // mid is a possible solution;
                // now search is the space [l -> mid -1]
                r = mid - 1;
                //minDiv = Math.min(minDiv, mid);
            }
        }

        // This loop quits when l > r, that means prior to quitting,
        // the search space was [l, r], where l == r or l + 1 == r,
        // which means m == l right before exiting the loop.
        // Now, since the solution is guaranteed,
        // mid_sum from that m could not have been greater than threshold.
        // It has to be < or == to threshold.
        // Therefore, right before exiting the loop, we must have set r = m - 1 (or l-1, resulting in loop breaking).
        // Also, taking m into a space where sum(m) must be greater than threshold,
        // otherwise it would have been part of the search space.
        // Hence, the smallest such divisor possible is l.
        // Therefore, we dont need to check the mins, we can just wait for the loop to quit and then return the l.
        // It also means the solution is always coming right after l == r or l + 1 == r, you can simulate and see that.

        return l;
    }

    private static int result(int[] nums, int divisor) {
        int result = 0;

        // To get ceiling of x/y,
        // ceil = 1 + (x-1)/y

        for (int curr : nums) {
            result += (1 + ((curr-1)/divisor));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {81488,78770,69737,14847,36203,85812,62771,25584,40434,55397,95643,48474,63802,63203,69258,16397,62134,68311,48931,4317,488,76613,70301,24052,67069,8018,61725,98992,86206,54407,33175,65597,5215,11866,9420,93851,66858,78097,70255,92021,50353,91451,52417,411,81332,27928,51842,83525,74458,10995,18792,14219,31190,86907,412,45731,9730,1258,94589,84673,20469,479,71501,68751,18230,77410,41662,9005,72532,36514,5203,528,59746,45580,72611,30386,40609,30783,70776,78765,97187,19997,16257,86367,80891,43219,55020,4753,2785,70141,86103,25092,50595,73151,69139,92893,18011,94848,65111,5657};
        //System.out.println(result(arr, 5318));
        System.out.println(smallestDivisor(arr, 988));
    }
}
