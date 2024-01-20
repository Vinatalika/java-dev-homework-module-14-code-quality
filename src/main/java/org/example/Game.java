package org.example;

import java.util.Scanner;

public class Game {
    private final GameBoard gameBoard;

    public Game() {
        gameBoard = new GameBoard();
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        boolean boxEmpty = false;

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean gameRunning = true;

        while (gameRunning) {
            gameBoard.display();

            if (!boxEmpty) {
                gameBoard.reset();
                boxEmpty = true;
            }

            if (checkGameOver()) {
                gameRunning = false;
            } else {
                playPlayerMove(scan);

                if (!checkGameOver()) {
                    playComputerMove();
                }

                if (checkGameOver()) {
                    gameRunning = false;
                }
            }
        }
    }

    private void playPlayerMove(Scanner scan) {
        byte input;

        while (true) {
            input = scan.nextByte();
            if (isValidInput(input) && !gameBoard.isOccupied(input)) {
                gameBoard.setValue(input, 'X');
                break;
            } else {
                System.out.println(isValidInput(input) ? "That one is already in use. Enter another." : "Invalid input. Enter again.");
            }
        }
    }

    private void playComputerMove() {
        byte randomMove;

        while (true) {
            randomMove = GameLogic.getRandomMove();
            if (!gameBoard.isOccupied(randomMove)) {
                gameBoard.setValue(randomMove, 'O');
                break;
            }
        }
    }

    private boolean checkGameOver() {
        if (GameLogic.checkWinner(gameBoard.getBox(), 'X')) {
            displayResult(1);
            return true;
        }

        if (GameLogic.checkWinner(gameBoard.getBox(), 'O')) {
            displayResult(2);
            return true;
        }

        if (!GameLogic.isAvailable(gameBoard.getBox())) {
            displayResult(1);
            return true;
        }

        return false;
    }

    private boolean isValidInput(byte input) {
        return input > 0 && input < 10;
    }

    private void displayResult(int i) {
        switch (i) {
            case 1:
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 2:
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            case 3:
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            default:
                System.out.println("The result is unknown.");
        }
    }

}