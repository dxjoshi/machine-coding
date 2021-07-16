package game2048.models;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private int[][] board;
    private final int size;
    private static final int randomTile = 2;
    private final Random random = new Random();
    public int[] emptyRow;
    public int[] emptyCol;
    public static boolean hasEmptyCell;
    public static boolean hasWinningNumber;
    public static boolean hasEqualAdjacentNumber;

    public Board(int size) {
        this.board = new int[size][size];
        this.emptyRow = new int[size];
        this.emptyCol = new int[size];
        this.size = size;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void enterRandomTile() {
        if (hasEmptyCell){
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            while (emptyRow[row] != 1 && emptyCol[col] != 1) {
                row = random.nextInt(size);
                col = random.nextInt(size);
            }
            board[row][col] = randomTile;
        }
    }

    protected boolean checkBoard() {
        reset(emptyCol);
        reset(emptyRow);
        hasEmptyCell = false;
        hasWinningNumber = false;
        hasEqualAdjacentNumber = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    emptyRow[i] = 1;
                    emptyCol[j] = 1;
                    hasEmptyCell = true;
                }
                if (board[i][j] == 2048) {
                    hasWinningNumber = true;
                }

                if ((i+1<size && board[i][j] == board[i+1][j])
                        || (i>0 && board[i][j] == board[i-1][j])
                        || (j+1<size && board[i][j] == board[i][j+1])
                        || (j>0 && board[i][j] == board[i][j-1])) {
                    hasEqualAdjacentNumber = true;
                }

            }
        }
        return hasEmptyCell;
    }

    public void enterRandomTiles(int count) {
        checkBoard();
        for (int i = 0; i < count; i++) {
            enterRandomTile();
        }
    }

    public void reset(int[] arr) {
        Arrays.fill(arr, 0);
    }

}
