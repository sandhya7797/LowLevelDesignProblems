package Models;

import Enums.BotDifficultyLevel;
import Enums.CellState;
import Enums.PlayerType;
import Models.Factory.BotPlayingStrategyFactory;
import Models.Strategy.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    //Bot also will have id, name, symbol so we are initializing all those attributes by calling parent constructor.
    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);//bot is the player here.
    return move;
    }

}
