package Models.Strategy.BotPlayingStrategy;

import Enums.CellState;
import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Strategy.BotPlayingStrategy.BotPlayingStrategy;

import java.util.List;

public class EasyBotPlayer implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board) {

        //iterate through board and whenever u find empty cell update there.

        for(List<Cell> row : board.getBoard()) {
            for(Cell cell : row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell,null);
                }
            }
        }

        return null;
    }
}
