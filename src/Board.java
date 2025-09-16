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

    // Check if any possible 'four in a row' at last move made
    public boolean fourInARow() {
        int lastRow = lastMove.getRow();
        int lastCol = lastMove.getCol();
        char symbol = grid[lastRow][lastCol];
        int symbolCount = 0;

        // Check horizontal
        for (int i = -3; i <= 3;i++) {
            int currCol = lastCol + i;
            // Skip if out of bounds
            if (currCol < 0 || currCol >= boardLength) {
                continue;
            }

            if (grid[lastRow][currCol] == symbol) {
                symbolCount++;
                if (symbolCount == 4) {
                    System.out.println("Horizontal win!");
                    return true;
                }
            } else {
                symbolCount = 0;
            }
        }

        // Check vertical
        symbolCount = 0;
        for (int i = -3; i <= 3; i++) {
            int currRow = lastRow + i;
            // Skip if out of bounds
            if (currRow < 0 || currRow >= boardHeight) {
                continue;
            }

            if (grid[currRow][lastCol] == symbol) {
                symbolCount++;
                if (symbolCount == 4) {
                    System.out.println("Vertical win!");
                    return true;
                }
            } else {
                symbolCount = 0;
            }
        }

        // Check diagonal: Top left to bottom right
        symbolCount = 0;
        for (int i = -3; i<= 3; i++) {
            int currRow = lastRow + i;
            int currCol = lastCol + i;
            // Skip if out of bounds
            if (currRow < 0 || currRow >= boardHeight
                    || currCol < 0 || currCol >= boardLength) {
                continue;
            }

            if (grid[currRow][currCol] == symbol) {
                symbolCount++;
                if (symbolCount == 4) {
                    System.out.println("Diagonal win! (top left to bottom right)");
                    return true;
                }
            } else {
                symbolCount = 0;
            }
        }

        // Check diagonal: Bottom left to top right
        symbolCount = 0;
        for (int i = -3; i<= 3; i++) {
            // Row - i to go from bottom up
            int currRow = lastRow - i;
            int currCol = lastCol + i;
            // Skip if out of bounds
            if (currRow < 0 || currRow >= boardHeight
                    || currCol < 0 || currCol >= boardLength) {
                continue;
            }

            if (grid[currRow][currCol] == symbol) {
                symbolCount++;
                if (symbolCount == 4) {
                    System.out.println("Diagonal win! (bottom left to top right)");
                    return true;
                }
            } else {
                symbolCount = 0;
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
