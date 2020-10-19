class Solution_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        
        int f_Index = 0;
        int s_Index = n;
        int curr_Index = 0;
        
        while(s_Index < 2*n) {
            arr[curr_Index++] = nums[f_Index++];
            arr[curr_Index++] = nums[s_Index++];
        }
        
        return arr;
    }
}
