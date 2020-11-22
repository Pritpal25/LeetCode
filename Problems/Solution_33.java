public class Solution_33
{
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length-1);

        if (target > nums[pivot]) {
            return -1;
        } else if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot, target);
        } else {
            return binarySearch(nums, pivot+1, nums.length-1, target);
        }
    }

    private static int findPivot(int[] nums, int l, int r) {
        // While searching for pivot, if you end up on just one element, then that has to be
        // pivot. Or if, the array is completely rotated(all elements), then also you will get
        // to a situation where while searching you'll end up being with a single element (
        // in this case, This single element will be the last element in the array).
        if (l == r) {
            return l;
        }

        int m = l + (r-l)/2;

        if (nums[m] > nums[m+1]) {
            return m;
        }

        if(nums[l] > nums[m]) {
            return findPivot(nums, l, m-1);
        } else {
            return findPivot(nums, m+1, r);
        }
    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r-l)/2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, l, mid-1, target);
        } else {
            return binarySearch(nums, mid+1, r, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};

        System.out.println(search(arr, 0));
    }
}
