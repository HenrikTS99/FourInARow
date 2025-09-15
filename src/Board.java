import java.util.Arrays;

public class Board {
    private char [][] grid = new char[6][7];
    private final int boardHeight = grid.length;
    private final int boardLength = grid[0].length;

    public Board() {
        resetBoard();
    }

    public int getBoardLength() {
        return boardLength;
    }

    public boolean placeToken(int column, char symbol) {
        for(int row = boardHeight - 1; row >=0; row--) {
            if (grid[row][column] == ' ') {
                grid[row][column] = symbol;
                return true;
            }
        }
        return false;
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
        System.out.print("     ");
        // Print column numbers
        for (int col = 1; col <= boardLength; col++) {
            System.out.print(col + "   ");
        }

        System.out.println();
        System.out.println("   " + "|---".repeat(boardLength) + "|");

        for (char row = 0, rowName = 'A'; row < boardHeight; row++, rowName++) {
            // Print row letters
            System.out.print(" "+ rowName);

            // Print each grid character
            for (int col = 0; col < boardLength; col++) {
                System.out.print(" | " + grid[row][col]);
            }

            System.out.println(" |");
            System.out.println("   " + "|---".repeat(boardLength) + "|");
        }
    }
}
