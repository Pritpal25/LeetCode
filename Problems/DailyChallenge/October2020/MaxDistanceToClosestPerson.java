package DailyChallenge.October2020;

public class MaxDistanceToClosestPerson
{
    public static int maxDistToClosest(int[] seats) {
        int count = 0;
        int start_index = 0;
        int len = seats.length;
        int end_index = len - 1;

        while(seats[start_index] == 0) {
            start_index++;
        }
        count = start_index;

        while(seats[end_index] == 0) {
            end_index--;
        }

        count = Math.max(count, len-1-end_index);

        int empty = 0;
        for (int i = start_index; i <= end_index; i++) {
            if (seats[i] == 0) {
                empty++;
            }
            else {
                // empty +1 to avoid having to do Math.ceil after division
                count = Math.max(count, (empty+1)/2);
                empty = 0;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[] {0,0,0,0,1,0,1}));
    }
}
