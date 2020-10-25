import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution_877
{
    static Map<Pair<Integer, Integer>, int[]> pilesToOptimalSolution = new HashMap<>();
    public static boolean stoneGame(int[] piles) {
        int length = piles.length;

        int alexCount = 0;
        int leeCount = 0;

        int l = 0, r = length-1;
        for(int i = 1; i <= length/2; i++) {   // Alex and Lee go for length/2 turns each, since length is even
            int[] choice = optimalPlay(piles, l, r); // Here 0 represent left pile and 1 represent right pile as the optimal play.
            alexCount += choice[1];
            if (choice[0] == 0) {
                l++;
            } else {
                r--;
            }

            choice = optimalPlay(piles, l, r);
            leeCount += choice[1];
            if (choice[0] == 0) {
                l++;
            } else {
                r--;
            }
        }

        return alexCount > leeCount;
    }

    private static int[] optimalPlay(int[] piles, int l, int r) {
        Pair<Integer, Integer> toCheck = new Pair<>(l, r);
        if (pilesToOptimalSolution.containsKey(toCheck)) {
            return pilesToOptimalSolution.get(toCheck);
        }

        int[] result;

        if (l == r) {
            result = new int[]{0, piles[l]};
        }
        else if (r == l+1) {
            if (piles[r] > piles[l]) {
                result = new int[]{1, piles[r]};
            } else {
                result = new int[]{0, piles[l]};
            }
        }
        else {
            int leftOptionCount = piles[l] + optimalPlay(piles, l+1, r)[1];
            int rightOptionCount = piles[r] + optimalPlay(piles, l, r-1)[1];

            if (leftOptionCount > rightOptionCount) {
                result = new int[] {0, leftOptionCount};
            } else {
                result = new int[] {1, rightOptionCount};
            }
        }
        
        pilesToOptimalSolution.put(toCheck, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5,3,4, 6, 2, 2, 4,2, 98, 5}));
    }
}
