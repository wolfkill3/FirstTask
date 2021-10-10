package dices;

public class Dice {
    public static int roll() {
        return (int) Math.round(1 + Math.random() * 5); //случайное число от 1 до 6
    }

    public static int roll(int diceCount) { // сумма нескольких брошенных костей
        int result = 0;

        for (int i = 0; i < diceCount; i++) {
            result += roll();
        }

        return result;
    }
}
