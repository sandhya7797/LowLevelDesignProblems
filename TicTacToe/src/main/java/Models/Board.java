package Models;


import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;

    private List<List<Cell>> board;

    public Board(int dimension) {
        this.size = dimension;
        this.board = new ArrayList<>(); //Outer list - []

        for(int i=0;i<size;i++) {//Outer list - []
            board.add(new ArrayList<>());//Inner list - [ [] [] [] [] [] ]
            for(int j=0;j<size;j++) {
                board.get(i).add(new Cell(i,j));//[ [cell cell cell] [cell cell cell] [cell cell cell] ]
            }
        }
    }

    public void printBoard() {
        System.out.println("Printing Board");

       for(List<Cell> lis : board) {
           for(Cell cell : lis) {
               cell.display();
           }
           System.out.println();
       }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
