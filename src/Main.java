//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoardArray();
        board.printBoard();

        Player player1 = new Player();

        boolean success;
        do {
            int columnChoice = player1.chooseColumn(board.getBoardLength());
            success = board.placeToken(columnChoice, 'X');
            board.printBoard();

            if (!success) {
                System.out.println("That column is full. Choose another one!");
            }
        } while (!success);
}
}