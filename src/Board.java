import java.util.Arrays;

public class Board {
    private char [][] grid = new char[6][7];
    private final int boardLength = grid.length;
    private final int boardHeight = grid[0].length;

    public Board() {
        resetBoard();
    }

    private void resetBoard() {
        // Enhanced for loop: iterate over array without using an index
        for (char[] row : grid) {
            // Arrays.fill: Assigns the specified value to every element of the entire array
            Arrays.fill(row, ' ');
        }
    }

    public void printBoardArray() {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void printBoard() {
        System.out.println("     1   2   3   4   5   6   7  ");
        System.out.println("   |---|---|---|---|---|---|---|");

        for (char row = 0, rowName = 'A'; row < boardLength; row++, rowName++) {
            System.out.print(" "+ rowName);

            for (int col = 0; col < boardHeight; col++) {
                System.out.print(" | " + grid[row][col]);
            }

            System.out.println(" |");
            System.out.println("   |---|---|---|---|---|---|---|");
        }
    }
}
