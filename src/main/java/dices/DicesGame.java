package dices;

import java.util.*;

public class DicesGame {
    public static void main(String[] args) throws InterruptedException {
        String playerName = "";
        String[] otherPlayersNames = null;
        int dicesCount = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                playerName = getPlayerName(playerName, scanner);
                otherPlayersNames = getOtherPlayersNames(otherPlayersNames, scanner);
                dicesCount = getDicesCount(dicesCount, scanner);
            } while (dicesCount <= 0 || otherPlayersNames == null);
        }

        List<String> allPlayers = new LinkedList<>();
        allPlayers.add(playerName);
        allPlayers.addAll(Arrays.asList(otherPlayersNames));

        DicesGameCycle gameCycle = new DicesGameCycle(allPlayers, dicesCount);
        gameCycle.start();
    }

    private static int getDicesCount(int dicesCount, final Scanner scanner) {
        if (dicesCount == 0) {
            System.out.println("Введите количество игральных костей");
            dicesCount = scanner.nextInt();
        }
        return dicesCount;
    }

    private static String getPlayerName(String playerName, final Scanner scanner) {
        if ("".equals(playerName)) {
            System.out.println("Введите ваше имя");
            playerName = scanner.nextLine();
        }
        return playerName;
    }

    private static String[] getOtherPlayersNames(String[] otherPlayersNames, final Scanner scanner) {
        if (otherPlayersNames == null) {
            System.out.println("Введите имена игроков через запятую");
            String players = scanner.nextLine();

            if (players.split(",").length != 0) {
                otherPlayersNames = players.split(",");
            }
        }
        return otherPlayersNames;
    }
}
