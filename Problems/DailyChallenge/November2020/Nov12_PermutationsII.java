package DailyChallenge.November2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nov12_PermutationsII
{
    static Set<List<Integer>> uniqueLists = new HashSet<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> list : uniqueLists) {
            ans.add(list);
        }

        return ans;
    }

    private static void permute(int[] nums, int l) {
        if (l == nums.length) {
            uniqueLists.add(arrToList(nums));
        } else {
            for(int i = l; i < nums.length; i++) {
                swap(nums, l, i);
                permute(nums, l+1);
                swap(nums, l, i);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static List<Integer> arrToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int x : arr) {
            list.add(x);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> ans = permuteUnique(nums);

        for(List<Integer> list : ans) {
            list.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }
}
