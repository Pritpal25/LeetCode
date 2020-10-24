public class Solution_1395
{
    public int numTeams(int[] rating) {
        // for each j -> 1 : n-1
        // get count of number smaller than rating[j] -> less[j]
        // get count of number greater than rating[j] -> more[j]
        // possible solutions for this j = less[j] * more[j]
        // add for all j
        // reverse the array, and then repeat above
        if (rating.length < 3) {
            return 0;
        }

        int total = count(rating);
        reverse(rating);
        return total + count(rating);
    }

    private int count(int[] rating) {
        int l = rating.length;
        int[] less_than = new int[l];
        int[] more_than = new int[l];

        int count = 0;
        less_than[0] = 0;
        for (int i = 1; i < l; i++) {
            for(int j = i-1; j>=0; j--) {
                if (rating[j] < rating[i]){
                    count++;
                }
            }
            less_than[i] = count;
            count = 0;
        }

        count = 0;
        more_than[l-1] = 0;
        for(int i = l-2; i >= 0; i--){
            for (int j = i+1; j < l; j++) {
                if (rating[j] > rating[i]) {
                    count++;
                }
            }
            more_than[i] = count;
            count = 0;
        }

        count = 0;
        for (int i = 0; i < l; i++) {
            count += less_than[i]*more_than[i];
        }

        return count;
    }

    private void reverse(int[] arr) {
        int r = arr.length-1;
        int l = 0;

        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
