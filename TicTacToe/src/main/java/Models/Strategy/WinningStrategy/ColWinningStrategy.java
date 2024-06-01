package Models.Strategy.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;


public class ColWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Symbol,Integer>> countMap = new HashMap<>();

    //TODO : common logic move to separate place
    @Override
    public boolean checkWinner(Board board, Move move) {

        //first get col for which we have to check winner
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        //check whether map is already created or not for the col
        if(!countMap.containsKey(col)) {
            countMap.put(col, new HashMap<>());
        }

        //get the colMap to update symbol count
        Map<Symbol, Integer> colMap = countMap.get(col);

        colMap.put(symbol, colMap.getOrDefault(symbol, 0)+1);

        //checkWinner in O(1) using Map of Map logic.
        if(colMap.get(symbol)==board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

        int col = lastMove.getCell().getCol();
        Symbol symbol = lastMove.getPlayer().getSymbol();

        Map<Symbol,Integer> colMap = countMap.get(col);

        colMap.put(symbol, colMap.get(symbol)-1);
    }
}
