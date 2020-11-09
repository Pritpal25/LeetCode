/*
Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 */

public class Solution_1020
{
    public static int numEnclaves(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        for(int i = 0; i < cols; i++) {
            if (A[0][i] == 1) {
                explore(A, 0, i);
            }
            if (A[rows-1][i] == 1) {
                explore(A, rows-1, i);
            }
        }

        for(int i = 0; i < rows; i++) {
            if (A[i][0] == 1) {
                explore(A, i, 0);
            }
            if (A[i][cols-1] == 1) {
                explore(A, i, cols-1);
            }
        }

        int result = 0;

        for(int i = 1; i < rows-1; i++) {
            for(int j = 1; j < cols -1; j++) {
                if (A[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    private static void explore(int[][] A, int r, int c) {
        A[r][c] = 0;

        int[] rows = new int[]{-1, 1, 0, 0};
        int[] cols = new int[]{0, 0, -1, 1};

        for (int move = 0; move < 4; move++) {
            int row = r + rows[move];
            int col = c + cols[move];
            if (safeMove(A, row, col) && A[row][col] == 1) {
                explore(A, row, col);
            }
        }
    }

    private static boolean safeMove(int[][] A, int row, int col) {
        return (row >= 0 && row < A.length && col >= 0 && col < A[0].length);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,0,1,1,1,0,1,1,1,0,1},{1,1,1,1,0,1,0,1,1,0,0},{0,1,0,1,1,0,0,0,0,1,0},{1,0,1,1,1,1,1,0,0,0,1},{0,0,1,0,1,1,0,0,1,0,0},{1,0,0,1,1,1,0,0,0,1,1},{0,1,0,1,1,0,0,0,1,0,0},{0,1,1,0,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0,0,0,0},{1,0,1,1,0,0,0,1,0,0,1}
        };

        System.out.println(numEnclaves(arr));
    }
}
