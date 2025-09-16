public class Game {

    Board board = new Board();
    Player player1 = new Player('X');
    Player player2 = new Player('O');
    Player currentPlayer = player1;
    int turns = 0;
    boolean gameOver = false;

    // Main game loop
    public void run() {
        board.printBoard();

        while (!gameOver) {
            makePlay(currentPlayer);
            board.printBoard();
            turns++;

            // Check if winner (only possible after 7 turns)
            if (board.fourInARow() && turns >= 7) {
                System.out.println("Winner is Player '" + currentPlayer.getSymbol() +"'!");
                gameOver = true;
            }

            // Stop game if board is full and no winners.
            if (turns == (board.getBoardLength() * board.getBoardHeight())) {
                System.out.println("Board is full! You're both losers.");
                gameOver = true;
            }
            switchPlayer();
        }
    }

    // Using ternary operator (condition ? valueIfTrue : valueIfFalse)
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // Ask player for column to play, if column is full, make player choose again.
    private void makePlay(Player currentPlayer) {
        boolean success;
        do {
            int columnChoice = currentPlayer.chooseColumn(board.getBoardLength());
            success = board.placeToken(columnChoice, currentPlayer.getSymbol());

            if (!success) {
                System.out.println("That column is full. Choose another one!");
            }
        } while (!success);
    }
}
