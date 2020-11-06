/*
You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q
where its concatenation is equal to s and the number of distinct letters in p and q are the same.

Return the number of good splits you can make in s.
 */
public class Solution_1525
{
    // This solution takes 26 mill secs, another iteration to improve upon the same
/*    public int numSplits(String s) {
        if (s.length() == 1) {
            return 0;
        }

        int result = 0;
        Set<Character> left = new HashSet<>();
        left.add(s.charAt(0));

        Set<Character> right = new HashSet<>();
        Map<Character, Integer> count = new HashMap<>();

        for(int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer val = count.get(c);
            if (val == null) {
                count.put(c, 1);
            }
            else {
                count.put(c, val + 1);
            }
            right.add(c);
        }

        if(left.size() == right.size()) {
            result++;
        }

        for (int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);
            left.add(c);

            Integer val = count.get(c);

            if (val == 1) {
                right.remove(c);
            }
            count.put(c, val - 1);

            if (left.size() == right.size()) {
                result++;
            }

        }

        return result;
    }*/

    public int numSplits(String s) {
        int l = s.length();

        // Return for trivial case
        if(l == 1) {
            return 0;
        }

        // Convert to primitive array, faster than string manipulation
        char[] data = s.toCharArray();
        int[] leftCount = new int[l];

        // Each  1 bit of this num will denote a unique character
        int num = 0;

        // Calculating distinct chars in a string
        for(int i = 0; i < l; i++) {
            // Bitwise OR with num will mask the num for uniqueue character count
            num |= (1 << (data[i] - 'a'));
            leftCount[i] = Integer.bitCount(num);
        }

        int count = 0;
        num = 0;
        int ans = 0;
        for (int i = l-1; i > 0; i--) {
            num |= (1 << (data[i] - 'a'));
            if (Integer.bitCount(num) == leftCount[i-1]) {
                ans++;
            }
        }

        return ans;
    }
}
