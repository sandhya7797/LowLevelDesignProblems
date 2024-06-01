package Models.Strategy.WinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board, Move lastMove);
}
