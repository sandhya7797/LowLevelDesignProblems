package Models.Factory;

import Enums.BotDifficultyLevel;
import Models.Strategy.BotPlayingStrategy.BotPlayingStrategy;
import Models.Strategy.BotPlayingStrategy.EasyBotPlayer;

public class BotPlayingStrategyFactory {

    private BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        return new EasyBotPlayer();
    }
}
