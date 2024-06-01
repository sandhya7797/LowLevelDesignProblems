package Models;

import Enums.CellState;

public class Cell {

    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    //Here we are taking only row and col from input or client. For making move we take input (row,col) from player.
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void display() {
        if(player==null) {
            System.out.print(" | " + " . " + " | ");
        } else {
            System.out.print(" | " + player.getSymbol().getAchar());
        }
    }
}
