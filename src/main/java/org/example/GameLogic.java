package org.example;

public class GameLogic {

    public static boolean isAvailable(char[] box) {
        for (byte i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWinner(char[] box, char player) {
        return checkLines(box, player) || checkDiagonals(box, player);
    }


    private static boolean checkLines(char[] box, char player) {
        for (int i = 0; i < 3; i++) {
            // Vertical
            if ((box[i] == player && box[i + 3] == player && box[i + 6] == player) ||
                    // Horizontal
                    (box[i * 3] == player && box[i * 3 + 1] == player && box[i * 3 + 2] == player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals(char[] box, char player) {
        // Diagonal
        return (box[0] == player && box[4] == player && box[8] == player) ||
                (box[2] == player && box[4] == player && box[6] == player);
    }

    public static byte getRandomMove() {
        return (byte) (Math.random() * 9 + 1);
    }
    private GameLogic() {
        throw new AssertionError("Instances of GameLogic should not be created.");
    }
}
