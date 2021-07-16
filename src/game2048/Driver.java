package game2048;

import game2048.controller.MoveImpl;
import game2048.controller.PrinterImpl;
import game2048.models.Board;
import game2048.models.Game;
import game2048.services.Move;
import game2048.services.Printer;

public class Driver {
    private static final Integer SIZE = 4;

    public static void main(String[] args) {

        Board board= new Board(SIZE);
        Move move = new MoveImpl();
        Printer printer = new PrinterImpl();

        Game game = new Game(board, move, printer);
        game.play();
    }
}
