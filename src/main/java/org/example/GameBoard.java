package org.example;

public class GameBoard {
    private final char[] box;

    public GameBoard() {
        box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void display() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    public boolean isOccupied(byte input) {
        return box[input - 1] == 'X' || box[input - 1] == 'O';
    }

    public void setValue(byte input, char value) {
        box[input - 1] = value;
    }

    public char[] getBox() {
        return box;
    }
}
