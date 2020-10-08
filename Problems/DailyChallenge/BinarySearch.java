class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, 0, nums.length-1, target);
    }
    
    private int binary(int[] nums, int l, int r, int t) {
        if (l > r) {
            return -1;
        }
        
        int m = (l + r)/2;
        
        if (nums[m] == t) {
            return m;
        }
        else if (nums[m] > t) {
            return binary(nums, l, m-1, t);
        }
        else {
            return binary(nums, m+1, r, t);
        }
    }
}
