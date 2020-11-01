package DailyChallenge.October2020;

public class ChampagneTower
{
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[100][100];

        tower[0][0] = poured;
        for (int r = 0; r < query_row; r++) {
            for(int c = 0; c <= r; c++) {
                double spill_over = (tower[r][c] - 1.0)/2.0;  // this is spillover on each side
                if (spill_over > 0.0) {
                    tower[r+1][c] += spill_over;
                    tower[r+1][c+1] += spill_over;
                }
            }
        }

        return Math.min(1.0, tower[query_row][query_glass]);
    }
}
