package Controllers;

import Enums.GameState;
import Exceptions.InvalidCountOfPlayersException;
import Exceptions.MoreThanOneBotNotAllowedException;
import Exceptions.NoUniquePlayerSymbolException;
import Models.Game;
import Models.Player;
import Models.Strategy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;


/* GameController class should be stateless.
 */

//TODO - handle exceptions and write user friendly messages.
public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidCountOfPlayersException, NoUniquePlayerSymbolException, MoreThanOneBotNotAllowedException {
        return Game.getBuilder().setDimension(dimension).setPlayers(players).setWinningStrategy(winningStrategies).build();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undo(Game game) {
        game.undo();
    }

    public String getWinner(Game game) {
        return game.getWinner().getName();//winner is also a player
    }
}
