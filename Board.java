import java.util.Arrays;

class Board {

    // constants for board settings
    private static final int BOARD_DIM = 16;
    private static final int CELL_DIM = 2;
    private static final int SEED_NUM = 2;

    private int[][] board;

    // constructor
    public Board() {
        board = new int[BOARD_DIM][CELL_DIM];
        initBoard();
    }

    // fill the board with the seeds
    private void initBoard() {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], SEED_NUM);
        }
    }

    public void printRawBoard() {
        System.out.printf("%s%n", Arrays.deepToString(board));
    }
}
