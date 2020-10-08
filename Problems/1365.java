class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        
        // Get count of each number
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        
        // Add to the count, the number of elements smaller than current number
        // Therefore, count[nums[i]] contains number of all elements <= nums[i]
        for(int i = 1; i < 101; i++) {
            count[i] += count[i-1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? 0 : count[nums[i]-1];
        }
        
        return nums;
    }
}
