package Models.Strategy.WinningStrategy;

import Models.*;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    Map<Symbol,Integer> leftDiagonalMap = new HashMap<>();
    Map<Symbol,Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Symbol symbol = move.getPlayer().getSymbol();

        //if row,col belongs to left diag update diagMap1 else other.
        //TODO : check whether below logic alone works for right diagonal if not go with row+col = board.getSize()-1
        if(row==col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.getOrDefault(symbol,0)+1);
        } else {
            rightDiagonalMap.put(symbol, rightDiagonalMap.getOrDefault(symbol,0)+1);
        }

        if(!leftDiagonalMap.isEmpty() && leftDiagonalMap.containsKey(symbol) && leftDiagonalMap.get(symbol)== board.getSize()) {
            return true;
        } else if(!rightDiagonalMap.isEmpty() && rightDiagonalMap.containsKey(symbol) && rightDiagonalMap.get(symbol)== board.getSize()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        Symbol symbol = lastMove.getPlayer().getSymbol();

        if(row==col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol)-1);
        } else if(row+col==board.getSize()-1) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)-1);
        }
    }
}
