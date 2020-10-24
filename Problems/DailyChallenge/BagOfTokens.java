package DailyChallenge;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BagOfTokens
{
    public static int bagOfTokensScore(int[] tokens, int P) {
        int score = 0;
        if (tokens.length == 0) {
            return 0;
        }

        Arrays.sort(tokens);

        Map<Pair<Integer, Integer>, Integer> pairToScore = new HashMap<>();
        return maxScore(tokens, 0, tokens.length-1, P, score, pairToScore);
    }

    private static int maxScore(int[] tokens, int left, int right, int power, int score, Map<Pair<Integer, Integer>, Integer> pairToScore) {
        Pair<Integer, Integer> pair = new Pair<>(left, right);
        if (pairToScore.containsKey(pair)) {
            return pairToScore.get(pair);
        }

        if (left == right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
            }
            pairToScore.put(pair, score);
            return score;
        }
        else if (right == left + 1) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                score = maxScore(tokens, left, right, power, score, pairToScore);
            }
            pairToScore.put(pair, score);
            return score;
        }
        else {
            if (pairToScore.containsKey(pair)) {
                return pairToScore.get(pair);
            }
            // Spending power to increase score
            int score_by_spending_power = 0;
            if (power >= tokens[left]) {
                pair = new Pair<>(left+1, right);
                if (pairToScore.containsKey(pair)) {
                    score_by_spending_power = pairToScore.get(pair);
                } else {
                    score_by_spending_power = maxScore(tokens, left + 1, right, power - tokens[left], score + 1, pairToScore);
                    pairToScore.put(pair, score_by_spending_power);
                }
            }
            // Spending score to increase score
            int score_by_spending_score = 0;
            if (score >= 1) {
                pair = new Pair<>(left, right -1);
                if (pairToScore.containsKey(pair)) {
                    score_by_spending_score = pairToScore.get(pair);
                } else {
                    score_by_spending_score = maxScore(tokens, left, right - 1, power + tokens[right], score -1, pairToScore);
                    pairToScore.put(pair, score_by_spending_score);
                }
            }

            score = Math.max(score, score_by_spending_power);
            score = Math.max(score, score_by_spending_score);
            pair = new Pair<>(left, right);
            pairToScore.put(pair, score);
            return score;
        }
    }

    public static void main(String[] args) {
        int[] token = new int[]{2897,6861,2070,5292,3402,9784,9718,2089,5660,3294,9685,9245,5861,7200,6813,3533,9163,8994,3306,7473,90,8163,5648,9523,3631,6257,3230,7827,6007,9874,10,1407,436,1258,9293,9486,4804,9466,8183,7786,7472,1876,5488,4238,9497,1738,1698,6588,1574,1100};
        System.out.println(bagOfTokensScore(token, 5039));
    }
}
