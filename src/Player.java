import java.util.Scanner;

public class Player {
    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // Choose which column to play token. Keep asking until valid column chosen
    public int chooseColumn(int maxCol ) {
        int column;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a column (1-" + maxCol + "): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next();
                column = -1;
            } else {
                column = scanner.nextInt();
            }

        } while (column < 1 || column > maxCol);

       // zero-base index choice
       return column - 1;
    }
}
