package DailyChallenge.November2020;

import java.util.Arrays;

public class Nov11_ValidSquares
{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = new int[][]{p1, p2, p3, p4};
        // Sol 1
        // generate all perm
        // for each permutation, check if its a valid square until you get a valid permutation
        // to validate : sides are all same length and diagnols are all same length
        // return permuteAndCheck(p, 0);

        // Sol 2
        // Sort points based on x axis
        // If 2 points are on the same x axis, sort them along the y axis to ensure a certain order
        // or points.
        Arrays.sort(p, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

        boolean result = false;

        return result || (d(p[0],p[1]) > 0 && (d(p[0],p[1]) == d(p[0],p[2]) && d(p[0],p[1]) == d(p[1],p[3]) && d(p[1],p[3]) == d(p[2],p[3])) && (d(p[0],p[3]) == d(p[1],p[2])));
        // Sol 3
        // Find all 6 distances between 4 given points.
        // A square should exactly have 2 non zero distances - one from side and the other from diagnals
    }

    private boolean permuteAndCheck(int[][] p, int l) {
        if (l == 4) {
            return check(p);
        } else {
            boolean res = false;
            for (int i = l; i < 4; i++) {
                swap(p, l, i);
                res = res || permuteAndCheck(p, l+1);
                if (res) {
                    break;
                }
                swap(p, l, i);
            }
            return res;
        }
    }

    private void swap(int[][] p, int a, int b) {
        int[] temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }

    private boolean check(int[][] p) {
        return (d(p[0],p[1]) > 0) && ((d(p[0],p[1]) == d(p[1],p[2]) && d(p[1],p[2]) == d(p[2],p[3]) && d(p[2],p[3]) == d(p[3],p[0])) && (d(p[0],p[2]) == d(p[1],p[3])));
    }

    private int d(int[] a, int[] b) {
        return ((a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]));
    }
}
