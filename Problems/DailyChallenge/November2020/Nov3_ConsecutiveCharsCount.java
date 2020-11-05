package DailyChallenge.November2020;

/*
Given a string s, the power of the string is the maximum length of a
non-empty substring that contains only one unique character.

Return the power of the string.
 */

public class Nov3_ConsecutiveCharsCount
{
    public int maxPower(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxPower = 1;
        int power = 1;

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                power++;
            } else {
                maxPower = Math.max(maxPower, power);
                power = 1;
            }
        }

        // in case the power element is at the last of the string
        maxPower = Math.max(maxPower, power);

        return maxPower;
    }
}
