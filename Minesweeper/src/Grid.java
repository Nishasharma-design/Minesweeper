import java.util.Random;

public class Grid {

   private char[][] grid;
   private final int size = 10;
   private final int mineCount = 10;
   private Random random;

   public Grid() {
    grid = new char[size][size];
    random = new Random();
    initializeGrid();
    placeMines();  
   }


   //fill the grid with '-'
   private void initializeGrid() {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            grid[i][j] = '-';
        }
    }
   }

   private void placeMines() {
    int minesPlaced = 0;
    while(minesPlaced < mineCount) {
        int row = random.nextInt(size);
        int col = random.nextInt(size);

        if (grid[row][col] != '*') {
            grid[row][col] = '*';
            minesPlaced++;
        }
    }
   }

    //check if a cell is a mine
   public boolean isMine(int row, int col) {
    return grid[row][col] == '*';
   }

   //updates a cell with the number of surrounding mines
   public void updateCell(int row, int col, int number) {
    grid[row][col] = (char) (number + '0');
   }

   //prints the current state of the grid
   public void printGrid() {
    for (int i = 0; i < size; i ++) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j < size; j++) {
            row.append(grid[i][j]).append("+");
        }
        System.out.println(row.toString());
    }
   }

   //checks if the user has won
   public boolean winWinCondition() {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (grid[i][j] != '*' && grid[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
   }

   public char[][] getGrid() {
    return grid;
   }
 
}

