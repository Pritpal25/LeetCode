class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        
        int c = 0;
        for(int i = 0; i < nums.length; i++) {
            List<Integer> l = index.get(nums[i]);
            
            if(l == null) {
                l = new ArrayList<Integer>();
                l.add(i);
                index.put(nums[i], l);
            }
            else {
                c += l.size();
                l.add(i);
                index.put(nums[i], l);
            }
        }
        
        return c;
    }
}
