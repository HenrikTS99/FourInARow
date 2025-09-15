import java.util.Scanner;

public class Player {
    private char Symbol;

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

       System.out.println(column);
       // zero-base index choice
       return column - 1;
    }
}
