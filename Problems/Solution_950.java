import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
Very good index manipulation technique using Deque.
Taking index from start and putting one index in the back
of the queue alternatively.
 */

public class Solution_950
{
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            index.add(i);
        }

        int[] result = new int[deck.length];
        for (int card : deck) {
            result[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        for(int card : deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})) {
            System.out.println(card);
        }
    }
}
