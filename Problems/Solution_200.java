/*
No of Islands

Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */

public class Solution_200
{
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int islandCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    exploreIsland(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void exploreIsland(char[][] grid, int row, int col) {
        // In the first iteration of the solution, I used a visited[][] array.
        // In this iteration, replaced the visited array by changing all the 1's to 0's
        grid[row][col] = '0';
        int[] rowNum = new int[]{-1, 1 , 0, 0};
        int[] colNum = new int[]{0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int potentialRow = row + rowNum[i];
            int potentialCol = col + colNum[i];

            if (isPossible(potentialRow, potentialCol, grid) && grid[potentialRow][potentialCol] == '1') {
                exploreIsland(grid, potentialRow, potentialCol);
            }
        }
    }

    private boolean isPossible(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
