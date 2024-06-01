package Models;

import Enums.PlayerType;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    private Scanner scanner;

    public Player(int id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board) {
        System.out.println("Enter row and col to which cell you want to make a move");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Move(new Cell(row,col), this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
