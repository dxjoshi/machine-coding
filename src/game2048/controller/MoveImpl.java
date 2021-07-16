package game2048.controller;

import game2048.models.Board;
import game2048.services.Move;

import java.util.Arrays;
import java.util.LinkedList;

public class MoveImpl implements Move {
    @Override
    public void up(Board board) {
        int[][] grid = board.getBoard();
        int[][] tiles = createCopy(grid);
        solve(tiles);
        board.setBoard(tiles);
    }

    @Override
    public void down(Board board) {
        int[][] grid = board.getBoard();
        int[][] newCopy = createCopy(grid);
        int[][] tiles = reverse(newCopy);
        solve(tiles);
        board.setBoard(reverse(tiles));
    }

    @Override
    public void right(Board board) {
        int[][] grid = board.getBoard();
        int[][] newCopy = createCopy(grid);
        int[][] tiles = reverse(transpose(newCopy));
        solve(tiles);
        board.setBoard(transpose(reverse(tiles)));
    }

    @Override
    public void left(Board board) {
        int[][] grid = board.getBoard();
        int[][] newCopy = createCopy(grid);
        int[][] tiles = transpose(newCopy);
        solve(tiles);
        board.setBoard(transpose(tiles));
    }

    private static int[][] transpose(int[][] input) {
        int[][] result = new int[input.length][];

        for (int x = 0; x < input.length; ++x) {
            result[x] = new int[input[0].length];
            for (int y = 0; y < input[0].length; ++y) {
                result[x][y] = input[y][x];
            }
        }

        return result;
    }

    private static int[][] reverse(int[][] input) {
        int[][] result = new int[input.length][];

        for (int x = 0; x < input.length; ++x) {
            result[x] = new int[input[0].length];
            for (int y = 0; y < input[0].length; ++y) {
                result[x][y] = input[x][input.length - y - 1];
            }
        }

        return result;
    }

    private int[][] createCopy(int[][] grid) {
        int size = grid.length;
        int[][] tiles = new int[size][size];
        for (int x = 0; x < size; ++x) {
            tiles[x] = Arrays.copyOf(grid[x], size);
        }
        return tiles;
    }

    private void solve(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > 0) {
                    list.add(grid[j][i]);
                }
            }

            //merge the tiles
            LinkedList<Integer> mergedTiles = merge(list);
            //update into the original grid
            for (int j = 0; j < grid.length; j++) {
                if (mergedTiles.size() > 0) {
                    grid[j][i] = mergedTiles.pop();
                } else {
                    grid[j][i] = 0;
                }
            }
        }
    }

    private LinkedList<Integer> merge(LinkedList<Integer> thisRow) {
        LinkedList<Integer> newRow = new LinkedList<>();
        while (thisRow.size() >= 2) {
            int first = thisRow.pop();
            int second = thisRow.peek();
            if (second == first) {
                int newNumber = first * 2;
                newRow.add(newNumber);
                thisRow.pop();
            } else {
                newRow.add(first);
            }
        }
        newRow.addAll(thisRow);
        return newRow;
    }

    public void print(int[][] grid) {
        StringBuilder gridbuilder = new StringBuilder();
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                gridbuilder.append(grid[i][j] + ", ");
            }
            gridbuilder.append(grid[i][size-1] + "\n");
        }
        System.out.println(gridbuilder);

    }
}

