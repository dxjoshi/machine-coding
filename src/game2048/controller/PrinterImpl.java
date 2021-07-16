package game2048.controller;

import game2048.models.Board;
import game2048.services.Printer;

public class PrinterImpl implements Printer {

    @Override
    public void print(Board board) {
        StringBuilder gridbuilder = new StringBuilder();
        int size = board.getSize();
        int[][] grid = board.getBoard();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                   gridbuilder.append(grid[i][j] + ", ");
            }
            gridbuilder.append(grid[i][size-1] + "\n");
        }
        System.out.println(gridbuilder);

    }
}
