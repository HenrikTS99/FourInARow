import java.util.Arrays;

public class Board {
    private char [][] grid = new char[6][7];
    private final int boardHeight = grid.length;
    private final int boardLength = grid[0].length;
    private Position lastMove;

    public Board() {
        resetBoard();
    }

    public int getBoardLength() {
        return this.boardLength;
    }

    public int getBoardHeight() {
        return this.boardLength;
    }

    // Place symbol token at the "bottom" free slot of the selected column
    public boolean placeToken(int column, char symbol) {
        for(int row = boardHeight - 1; row >=0; row--) {
            if (grid[row][column] == ' ') {
                grid[row][column] = symbol;
                lastMove = new Position(row, column);
                return true;
            }
        }
        // Return false if no spot for token (column is full)
        return false;
    }

    // Return true if four in a row, and prints out the direction won in.
    public boolean fourInARow() {
        char symbol = grid[lastMove.getRow()][lastMove.getCol()];
        // Check horizontal
        if (checkDirection(0, 1, symbol)) {
            System.out.println("Horizontal win!");
            return true;
        }
        // Check vertical
        if (checkDirection(1, 0, symbol)) {
            System.out.println("Vertical Win!");
            return true;
        }
        // Check diagonal: Top left to bottom right
        if (checkDirection(1, 1, symbol)) {
            System.out.println("Diagonal win! (top left to bottom right)");
            return true;
        }
        // Check diagonal: Bottom left to top right
        if (checkDirection(-1, 1, symbol)) {
            System.out.println("Diagonal win! (bottom left to top right)");
            return true;
        }
        return false;
    }

    // Check for 4 symbols in a row in the direction specified by dRow and dCol
    private boolean checkDirection(int dRow, int dCol, char symbol) {
        int count = 0;

        for (int i = -3; i <= 3; i++) {
            int currRow = lastMove.getRow() + i * dRow;
            int currCol = lastMove.getCol() + i * dCol;

            // Skip if out of bounds
            if (currCol < 0 || currCol >= boardLength || currRow < 0 || currRow >= boardHeight) continue;

            if (grid[currRow][currCol] == symbol) {
                count++;
                if (count == 4) return true;
            } else {
                count = 0;
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

    // For debugging
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
