//public means this method can be accessed from anywhere in the program

import java.util.Scanner;

public class Minesweeper {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid();

        while (true) {
            grid.printGrid();

            System.out.println("Enter row and column between (0-9):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (grid.isMine(row, col)) {
                System.out.println("Game Over! You hit a mine.");
                System.out.println("Game Over. Final Grid:");
                grid.printGrid();
                break;
            } else {
                int minesAround = MineCounter.surroundingMines(grid.getGrid(), row, col);
                grid.updateCell(row, col, minesAround);
            }

            if (grid.winWinCondition()) {
                System.out.println("Congratulations! You Won!");
                System.out.println("Game Over. Final Grid:");
                grid.printGrid();
                break;
            }
        }
        scanner.close();
     }


}


//Minesweeper.java handles game loop and user input

// static means this variable belongs to the class instead to an object
// I am 
// since the board is always 10*10, i am using "final" to prevent accidentaly
//modifications

/* StringBuilder creates an empty mutable string where we can add characters.
 * row.append(grid[i][j]).append(" ");
 * I am storing each character in a StringBuilder with a space.
 * System.out.println(row.toString()) - instead of printing each character
 * separately, i am printing the whole row in one command
 */

//constructor job is to set up an instance of a class, but main() is a method that starts 
//program execution
//main() is not a constructor because it has a return type( void )
//main() is static, Static methods belong to the class, not objects.
//constructors are used to create objects, so they cant be static
//*** a class is a blueprint for objects 
/* an object is the actual thing created from that blueprint
 * main() can create objects but it does not do it automatically because its job
 * is only to start the program and not to create things
 * static means "this belongs to the class, not an object".
 * 
*/ 


//char[][] is a data type, just like int, double or string.
//chat - a single character 'A','B','C', '1', '-'
//char[] - a one-dimensional array of characters
//char[][] - a two-dimensional array(basically a table with rows and columns)

//Declaration - char[][] grid - a grid of 2D array of characters
//Initialization - new char[10][10] is a 10*10 grid

//main is a method, in java, it is the entry point of program. 
//string[] is an array of string.
//args - a variable that holds command-line arguments


//✅ Classes CANNOT be static, except for nested classes.
//✅ A static method means you can call it without an object.
//✅ If a method is NOT static, you must create an object before calling it.
 /* 
 * 
 */

 //random is inside main() because random is only needed in main(),
 //it generates random numbers for placing mines
 //there is no need to make it global because we dont need it anywhere else
 //if we define Random outside main, we can use it in multiple methods

 /*public static void main(String[] args) {
        char[][] grid = new char[10][10];
        Random random = new Random(); //Create a Random object
        Scanner scanner = new Scanner(System.in); //Scanner allows the user to enter numbers
//new Scanner means we are telling java to listen to what the user types on keyboard
//Scanner is a class in java and scanner is just a name we give to this object

        //looping through each row(i) and each column(j), and setting every cell to '-'
        //meaning it is hidden, initializing grid with '-'
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                grid[i][j] = '-';
            }
        }

        //place 10 mines at random locations
      int minesPlaced = 0; 
      while (minesPlaced < 10) { //keeps placing mines until we have placed 10 mines
        int row = random.nextInt(10); //reads an integer from the user and storing in row
        int col = random.nextInt(10); //reads another integer
        
        if (grid[row][col] != '*') {  //placing a mine only if spot is empty
            grid[row][col] = '*';
            minesPlaced++;
        }
    
    }
//when java sees char + " ", it implicitly converts the char to a string
//before printing
      //Game loop: Ask user for input
      while (true) {
       // Print grid (current state)
       printGrid(grid);
      
      System.out.println("Enter row and column between (0-9):");
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      if (grid[row][col] == '*') {
        System.out.println("Boom! You hit a mine. Game Over!");
        System.out.println("Game Over. Final Grid:");
        printGrid(grid);
        break; //this stops the program
      } else {
        int minesAround = surroundingMines(grid, row, col);
        grid[row][col] = (char) (minesAround + '0');

        if (winWinCondition(grid)) {
            System.out.println("Congratulations! You Won!");
            System.out.println("Game Over. Final Grid:");
            printGrid(grid);
        } 
              }
            }
            scanner.close(); //a good practice to close scanner bcz it frees up memory
            }
        
            private static void printGrid(char[][] grid) {
                for(int i = 0; i < 10; i++) {
                    StringBuilder row = new StringBuilder(); //we are creating empty row string
                    for(int j = 0; j < 10; j++) {
                      row.append(grid[i][j]).append("+"); //add each character with a space
                      
                    }
                    System.out.println(row.toString()); //print the entire row at once
                }
            }
        
            //method to count surrounding mines
    public static int surroundingMines(char[] [] grid, int row, int col) {
        int surroundingMinesCount = 0; 

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; //this refers to the one cell(that user selects)

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

    public static boolean winWinCondition(char[][] grid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] != '*' && grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
  * 
  */