package DailyChallenge.November2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nov12_PermutationsII
{
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums, 0);

        return ans;
    }

    private static void permute(int[] nums, int l) {
        if (l == nums.length) {
            ans.add(arrToList(nums));
        } else {
            // At each position while constructing the permutation, make sure that no 2 same
            // elements are used. Earlier I was using a boolean to check that, but that made
            // an inherent assumption that the array would always remain sorted. That hoever is
            // not true.
            // Eg : 0, 0, 0, 1, 9 : this changes to 9, 0, 0, 1, 0 after first swap and from 2nd
            // element onwards the array isnt sorted.
            // Therefore change the approach to use a set and no need of sorting at all.
            Set<Integer> used = new HashSet<>();
            for(int i = l; i < nums.length; i++) {
                if(!used.contains(nums[i])) {
                    used.add(nums[i]);
                    swap(nums, l, i);
                    permute(nums, l+1);
                    swap(nums, l, i);
                }
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
        int[] nums = new int[]{1, 2, 2, 3};
        List<List<Integer>> ans = permuteUnique(nums);

        System.out.println(ans.size());
        for(List<Integer> list : ans) {
            list.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }
}