package DailyChallenge.November2020;

public class Nov10_FlippingAnImage
{
    public int[][] flipAndInvertImage(int[][] A) {
        int cols = A[0].length;

        for(int i = 0, j = cols-1; i <= j; i++, j--) {
            for (int k = 0; k < A.length; k++) {
                if (i == j) {
                    A[k][i] = ((A[k][i] == 0) ? 1 : 0);
                }
                else {
                    int temp = ((A[k][j] == 0) ? 1 : 0);
                    A[k][j] = ((A[k][i] == 0) ? 1 : 0);
                    A[k][i] = temp;
                }
            }
        }

        return A;
    }
}
