package Models;

import Enums.CellState;
import Enums.GameState;
import Enums.PlayerType;
import Exceptions.InvalidCountOfPlayersException;
import Exceptions.MoreThanOneBotNotAllowedException;
import Exceptions.NoUniquePlayerSymbolException;
import Models.Strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* Game class is like the manager class for all entities used in the game.
   Since we have to perform some validation before creating the Game obj, we choose Builder design pattern.
   New variant of builder dp is implemented below. check comments.
 */

public class Game {
    private Board board;
    private List<Player> players;
    private List<WinningStrategy> winningStrategy;
    private GameState gameState;
    private int nextMovePlayerIndex;//To keep track of next player.
    private Player winner;//To show or print the winner.
    private List<Move> moves;//It is useful for UNDO feature.

    //Builder DP - Initialize parameters only which are taken as part of input, others will get re-initialized during program execution.
    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategy) {
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.nextMovePlayerIndex = 0;
        this.gameState = GameState.INPROGRESS;
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
    }

    public static Builder getBuilder() {
        return new Builder();
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    //Dimension, players and winning strategies all these three attributes are taken from client or Input.
    public static class Builder {

        private int dimension;//TODO - figure out why it is created here.
        private List<Player> players;
        private List<WinningStrategy> winningStrategy;

        public List<Move> getMoves() {
            return moves;
        }

        public void setMoves(List<Move> moves) {
            this.moves = moves;
        }

        private List<Move> moves;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        //we can use either of one from setPlayer() and addPlayer().
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        //we can use either of one from setWinningStrategy() and addWinningStrategy().
        public Builder setWinningStrategy(List<WinningStrategy> winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy.add(winningStrategy);
            return this;
        }

        //Validation on input is being done before returning Game obj.
        public Game build() throws InvalidCountOfPlayersException, NoUniquePlayerSymbolException, MoreThanOneBotNotAllowedException {
            validate();
            return new Game(dimension, players, winningStrategy);
        }

        public void validate() throws NoUniquePlayerSymbolException, MoreThanOneBotNotAllowedException, InvalidCountOfPlayersException {
            validatePlayerSymbols();
            validateCountOfBots();
            validateCountOfPlayers();
        }

        //TODO - validation on bot symbols vs player symbols.
        public void validatePlayerSymbols() throws NoUniquePlayerSymbolException {
            int players_count = players.size();
            HashSet<Symbol> set = new HashSet<>();
            for(Player p : players) {
                set.add(p.getSymbol());
            }
            if(players_count!=set.size()) {
                throw new NoUniquePlayerSymbolException();
            }
        }

        public void validateCountOfBots() throws MoreThanOneBotNotAllowedException {
            int bot_count = 0;
            for(Player p : players) {
                if(p.getPlayerType()== PlayerType.BOT) {
                    bot_count++;
                }
            }
            if(bot_count>1) {
                throw new MoreThanOneBotNotAllowedException();
            }
        }

        public void validateCountOfPlayers() throws InvalidCountOfPlayersException {
            int player_count = 0;
            for(Player p : players) {
                player_count++;
            }
            if(player_count!=dimension-1) {
                throw new InvalidCountOfPlayersException();
            }
        }
    }

    public void printBoard() {
        board.printBoard();
    }

    private boolean checkWinner(Board board, Move move) {
        for(WinningStrategy winningStrategy : winningStrategy) {
            if(winningStrategy.checkWinner(board,move)) {
                return true;
            }
        }
        return false;
    }

    //TODO - break this code further (SRP) ex - can move validation logic to separate class.
    public void makeMove() {

        Player currentMovePlayer = players.get(nextMovePlayerIndex);

//        if(player.getPlayerType()==PlayerType.HUMAN) {
//            //
//        } else {
//
//        }

        System.out.println("Hey " + currentMovePlayer.getName() + " it's turn. Please make a move.");
        Move move = currentMovePlayer.makeMove(board);//polymorphism (move taken from human or bot at runtime)

        int rowToUpdateCell = move.getCell().getRow();
        int colToUpdateCell = move.getCell().getCol();

        //validation
        if(!validateMove(move)) {
            System.out.println("Invalid move. Please make move again !");
            return;
        }

        Cell cellToMakeChange = board.getBoard().get(rowToUpdateCell).get(colToUpdateCell);
        cellToMakeChange.setCellState(CellState.FILLED);
        cellToMakeChange.setPlayer(currentMovePlayer);

        Move lastMove = new Move(cellToMakeChange, currentMovePlayer);

        moves.add(lastMove);

        nextMovePlayerIndex += 1;
        nextMovePlayerIndex = (nextMovePlayerIndex)%(board.getSize()-1);//if 3 players play 3 moves after that it gives out of bound.

        //TODO : see if you can update in different method and checkWinner() in different method.

        if(checkWinner(board, move)) {
            gameState = GameState.WINNER;
            winner = currentMovePlayer;
        } else if(moves.size()== board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }

    }

    public void undo() {

        if(moves.isEmpty()) {
            System.out.println("No moves to undo");
            return;
        }

        Move lastMove = moves.get(moves.size()-1);
        moves.remove(lastMove);

        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        for(WinningStrategy winningStrategy : winningStrategy) {//TODO : why all 3 winning strategies here.
            winningStrategy.handleUndo(board,lastMove);
        }

        nextMovePlayerIndex -= 1;
        nextMovePlayerIndex = (nextMovePlayerIndex + players.size()) % board.getSize()-1;
    }

    public boolean validateMove(Move move) {

        if(move.getCell().getRow()>=board.getSize() || move.getCell().getCol()>= board.getSize()) {
            return false;
        }

        if(move.getCell().getCellState().equals(CellState.EMPTY)) {
            return true;
        }
        return false;
    }
}
