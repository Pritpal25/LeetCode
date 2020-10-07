class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = 0;
        
        for (int i = 0; i < candies.length; i++) {
            largest = candies[i] > largest ? candies[i] : largest;
        }
        
        List<Boolean> result = new ArrayList<>();
        
        for (int i = 0; i < candies.length; i++) {
            if (largest - extraCandies <= candies[i]) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        
        return result;
    }
}
