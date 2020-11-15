package DailyChallenge.November2020;

public class Nov14_PoorPigs
{
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testsPerPig = 1 + (minutesToTest/minutesToDie);

        int minPigs = 0;
        while(Math.pow(testsPerPig, minPigs) < buckets) {
            minPigs++;
        }

        return minPigs;

    }
}
