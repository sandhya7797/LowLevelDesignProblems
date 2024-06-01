import Controllers.GameController;
import Enums.BotDifficultyLevel;
import Enums.GameState;
import Enums.PlayerType;
import Exceptions.InvalidCountOfPlayersException;
import Exceptions.MoreThanOneBotNotAllowedException;
import Exceptions.NoUniquePlayerSymbolException;
import Models.Bot;
import Models.Game;
import Models.Player;
import Models.Strategy.WinningStrategy.ColWinningStrategy;
import Models.Strategy.WinningStrategy.DiagonalWinningStrategy;
import Models.Strategy.WinningStrategy.RowWinningStrategy;
import Models.Strategy.WinningStrategy.WinningStrategy;
import Models.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) throws InvalidCountOfPlayersException, NoUniquePlayerSymbolException, MoreThanOneBotNotAllowedException {

        Scanner sc = new Scanner(System.in);

        int dimension = 3;

        List<Player> players = new ArrayList<>();

        players.add(new Player(1,"Sandhya",new Symbol('X'), PlayerType.HUMAN));

        players.add(new Bot(1,"Mahesh",new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();

        Game game = gameController.startGame(dimension,players,winningStrategies);

        while(game.getGameState()== GameState.INPROGRESS) {

            //Print Board, check Game State and Make Move

            gameController.printBoard(game);

            System.out.println("Do you want to make undo : [y/n] ");
            String userUndoResponse = sc.next();

            if(userUndoResponse.equalsIgnoreCase("y")) {
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        if(gameController.checkState(game).equals(GameState.WINNER)) {
            System.out.println("Game is Over");
            System.out.println("We have a winner : " + gameController.getWinner(game));
        } else {
            System.out.println("Game got Draw");
            System.out.println("There is no Winner");
        }

        gameController.printBoard(game);

    }
}
