public class Game {

    Board board = new Board();
    Player player1 = new Player('X');
    Player player2 = new Player('O');
    Player currentPlayer = player1;
    boolean player1Turn = true;
    int turns = 0;
    boolean gameOver = false;

    public void run() {

        while (!gameOver) {
            makePlay(currentPlayer);
            board.printBoard();

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
            turns++;
        }
    }

    private void makePlay(Player currentPlayer) {
        boolean success;
        do {
            int columnChoise = currentPlayer.chooseColumn(board.getBoardLength());
            success = board.placeToken(columnChoise, currentPlayer.getSymbol());

            if (!success) {
                System.out.println("That column is full. Choose another one!");
            }
        } while (!success);
    }
}
