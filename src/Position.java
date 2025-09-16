public class Position {
    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    // For debugging
    public void printPosition() {
        System.out.println("Position (row/column: " + this.row + "/" + this.col );
    }
}
