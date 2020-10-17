package session04;

import java.util.Scanner;

public class HangmanGame {

    private Scanner input;

    private HangmanGame() {
        input = new Scanner(System.in);
    }

    private Hangman game;

    private void run() {
        game = new Hangman(7);
        game.addPlayer(readPlayer(1));
        game.addPlayer(readPlayer(2));

        do {
            readNewWord();
            while (game.canMakeGuess()) {
                if (game.guess(readGuess())) {
                    System.out.println("that is correct!");
                } else {
                    System.out.println("that is false...");
                }
                System.out.println(game);

            }

            if (game.guesserHasWon()) {
                System.out.println(game.getWordguesser() + " has won!");
            } else {
                System.out.println(game.getWordguesser() + " has lost!");
            }

            game.swapPlayers();

        } while (readContinue());

    }

    private Player readPlayer(int i) {
        System.out.printf("Hello! What is your name? ", i);
        return new Player(input.nextLine());
    }

    private void readNewWord() {
        System.out.print(game.getWordProvider() + " give me a word that " + game.getWordguesser() + " needs to guess: ");
        String word = input.nextLine();
        while (!game.setNewWord(word)) {
            word = input.nextLine();
        }

    }

    private String readGuess() {
        System.out.println(game.getWordguesser() + " Give me a letter:  ");
        return input.nextLine();
    }

    private boolean readContinue() {
        System.out.print("Do you want to continue (y/n)? ");
        String continueOrNot = input.nextLine();
        return ("yes".equals(continueOrNot) || "y".equals(continueOrNot));
    }

    public static void main(String[] args) {
        new HangmanGame().run();
    }

}
