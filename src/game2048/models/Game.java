package game2048.models;

import game2048.services.Move;
import game2048.services.Printer;

import java.util.Scanner;

public class Game {

    public final Board board;
    public final Move move;
    public final Printer printer;
    private State gameState;

    public Game(Board board, Move move, Printer printer) {
        this.board = board;
        this.move = move;
        this.printer = printer;
        this.gameState = State.INIT;
    }

    public void play() {
        while (gameState != State.WIN && gameState != State.LOSE) {
            if (gameState == State.INIT) {
                System.out.println("You can move in 4 directions: UP, DOWN, LEFT, RIGHT. Enter");
                System.out.printf("0 for moving left\n1 for moving right\n2 for moving top\n3 for moving bottom%n");
                board.enterRandomTiles(2);
                setGameState(State.IN_PROGRESS);
                printer.print(board);
            }
            nextMove();
        }
        if (gameState == State.WIN) {
            System.out.println("Congratualtions!!");
        } else if (gameState == State.LOSE) {
            System.out.println("Game Over!!");
        }
    }

    private void nextMove() {
        System.out.println("Next move: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Direction direction = Direction.getDirection(input);
        process(direction);
        printer.print(board);
    }

    private void process(Direction direction) {
        switch (direction) {
            case UP:
                move.up(board);
                if (State.IN_PROGRESS == getNewState(board)) {
                    board.enterRandomTile();
                }
                break;
            case DOWN:
                move.down(board);
                if (State.IN_PROGRESS == getNewState(board)) {
                    board.enterRandomTile();
                }
                break;
            case LEFT:
                move.left(board);
                if (State.IN_PROGRESS == getNewState(board)) {
                    board.enterRandomTile();
                }
                break;
            case RIGHT:
                move.right(board);
                if (State.IN_PROGRESS == getNewState(board)) {
                    board.enterRandomTile();
                }
                break;
            default:
                System.out.println("Please enter a valid move!!");
        }
    }

    private State getNewState(Board board) {
        State newState = State.IN_PROGRESS;
        board.checkBoard();

        if (Board.hasWinningNumber) {
            newState = State.WIN;
        } else if (!Board.hasEqualAdjacentNumber && !Board.hasEmptyCell) {
            newState = State.LOSE;
        }
        setGameState(newState);
        return newState;
    }

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }
}
