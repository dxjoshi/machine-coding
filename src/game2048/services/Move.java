package game2048.services;

import game2048.models.Board;

public interface Move {
    void up(Board board);

    void down(Board board);

    void right(Board board);

    void left(Board board);
}
