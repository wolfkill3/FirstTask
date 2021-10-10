package dices;

import java.util.*;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class DicesGameCycle {
    private static final int WINS_TO_WIN = 7;
    private static final long DELAY_BETWEEN_ROUNDS = 500;
    private static final long DELAY_BETWEEN_THROWING = 300;
    private final int dicesCount; // количество костей
    private Map<String, Integer> scoreByPlayerId = new LinkedHashMap<>(); // количество игроков и очередность бросков

    public DicesGameCycle(final List<String> playerNames, final int dicesCount) {
        this.dicesCount = dicesCount;
        populatePlayers(playerNames);
    }

    private void populatePlayers(final List<String> playerNames) {
        for (String name : playerNames) {
            scoreByPlayerId.put(name, 0);
        }

        scoreByPlayerId.put("Computer", 0); //добавляем компьютер
    }

    public void start() throws InterruptedException {
        int round = 1;
        do {
            System.out.println("--------------------Раунд " + (round) + " начинается!---------------------\n");
            Pair<String, Integer> winner = runGameRound();

            System.out.println("В " + (round) + " раунде побеждает игрок " + winner.getLeft()
                               + " набрав " + winner.getRight() + " очков!\n");

            int currentWinnerScore = scoreByPlayerId.get(winner.getLeft()) + 1;

            if (currentWinnerScore == WINS_TO_WIN) {
                showStatistic(winner.getLeft());
                break;
            }

            reshufflePlayers(winner.getLeft(), currentWinnerScore);
            round++;
            Thread.sleep(DELAY_BETWEEN_ROUNDS);
        } while (true);
    }

    private void showStatistic(final String winner) {
        System.out.println("Победитель - " + winner);
        System.out.println("Статистика:");
        scoreByPlayerId.forEach((name, score) -> System.out.println("Игрок " + name + " выиграл " + score + " раундах!"));
    }

    private Pair<String, Integer> runGameRound() throws InterruptedException {
        String winnerName = "";
        int higherValue = 0;
        for (String playerName : scoreByPlayerId.keySet()) {
            int playerPoints = Dice.roll(dicesCount);

            if (playerPoints > higherValue) {
                higherValue = playerPoints;
                winnerName = playerName;
            }

            System.out.println("Игрок " + playerName + " бросает " + dicesCount + " кость(и)(ей)");
            System.out.println("...");
            Thread.sleep(DELAY_BETWEEN_THROWING);
            System.out.println("суммарное количество очков " + playerPoints + "\n");
        }

        return new ImmutablePair<>(winnerName, higherValue);
    }

    private void reshufflePlayers(final String winnerName, final int higherValue) {
        scoreByPlayerId.remove(winnerName);
        Map<String, Integer> reshuffledPlayers = new LinkedHashMap<>();
        reshuffledPlayers.put(winnerName, higherValue);
        scoreByPlayerId.forEach(reshuffledPlayers::put);
        scoreByPlayerId = reshuffledPlayers;
    }
}
