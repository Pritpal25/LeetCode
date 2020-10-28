package DailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges
{
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        String toAdd;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != (nums[i-1] + 1)) {
                if (nums[i-1] == start) {
                    toAdd = Integer.toString(start);
                }
                else {
                    // Use Stringbuilder for string manipulation
                    // Way more faster than string manipulation.
                    StringBuilder str = new StringBuilder();
                    str.append(Integer.toString(start)); str.append("->"); str.append(Integer.toString(nums[i-1]));
                    toAdd =  str.toString();
                }
                result.add(toAdd);
                start = nums[i];
                continue;
            }
        }

        if (nums[nums.length-1] == start) {
            toAdd = Integer.toString(start);
        }
        else {
            StringBuilder str = new StringBuilder();
            str.append(Integer.toString(start)); str.append("->"); str.append(Integer.toString(nums[nums.length-1]));
            toAdd =  str.toString();
        }
        result.add(toAdd);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = summaryRanges(new int[]{0,2,3,4,6,8,9});
        for(String str : result) {
            System.out.println(str);
        }
    }
}
