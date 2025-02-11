public class MineCounter {

    public static int surroundingMines(char[][] grid, int row, int col) {
        int surroundingMinesCount = 0;

        for (int i = -1; i < 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ( i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < 10 && newCol >= 0 && newCol < 10) {
                    if (grid[newRow][newCol] == '*') {
                        surroundingMinesCount++;
                    }
                }

            }
        }

        return surroundingMinesCount;
    }
    
}
