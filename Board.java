import java.util.Arrays;

// lets consider the board also holds the score and the turn
class Board {

    // constants for player turn and turn number
    private int turnNum;
    private int playerTurn; // lets say we'll add the update logic in the Game class

    // constants for board settings
    private static final int BOARD_DIM = 16;
    private static final int CELL_DIM = 2;
    private static final int SEED_NUM = 2;

    private int[][] board;

    // constructor
    public Board() {
        turnNum = 0;
        playerTurn = 0;
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
        System.out.printf("Turn number: %d\n", turnNum);
        System.out.printf("Turn of player n°%d\n", playerTurn);
        System.out.printf("Board: %s%n", Arrays.deepToString(board));
    }
}
