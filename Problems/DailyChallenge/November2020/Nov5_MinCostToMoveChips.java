/*
We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

    position[i] + 2 or position[i] - 2 with cost = 0.
    position[i] + 1 or position[i] - 1 with cost = 1.

Return the minimum cost needed to move all the chips to the same position.
 */

package DailyChallenge.November2020;

public class Nov5_MinCostToMoveChips
{
    public int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < position.length; i++) {
            if ((position[i] & 1) == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }

        return oddCount < evenCount ? oddCount : evenCount;
    }
}
