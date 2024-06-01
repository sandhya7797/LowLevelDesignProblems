package Models.Strategy.WinningStrategy;

import Models.*;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Symbol,Integer>> countMap = new HashMap<>();

    //TODO : common logic move to separate place
    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!countMap.containsKey(row)) {
            countMap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> colMap = countMap.get(row);

        colMap.put(symbol, colMap.getOrDefault(symbol,0)+1);

        if(colMap.get(symbol)==board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        Symbol symbol = lastMove.getPlayer().getSymbol();

        Map<Symbol,Integer> rowMap = countMap.get(row);

        rowMap.put(symbol, rowMap.get(symbol)-1);
    }
}
