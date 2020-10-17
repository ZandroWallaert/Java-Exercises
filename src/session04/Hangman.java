package session04;

public class Hangman {
    private int numberOfTurns;
    private int currentTurn;
    private Player wordguesser;
    private Player wordProvider;
    private SecretWord secretWord;

    Player getWordguesser() {
        return wordguesser;
    }

    Player getWordProvider() {
        return wordProvider;
    }

    Hangman(int nt) {
        numberOfTurns = nt;
        currentTurn = 0;
    }

    boolean setNewWord(String newWord) {
        secretWord = new SecretWord(newWord);
        return true;
    }

    void addPlayer(Player player) {
        if (wordProvider == null) {
            wordProvider = player;
        } else if (wordguesser == null) {
            wordguesser = player;
        }
    }

    boolean canMakeGuess() {
        return currentTurn < numberOfTurns && !secretWord.isRevealed();
    }

    void swapPlayers() {
        Player current = wordProvider;
        wordProvider = wordguesser;
        wordguesser = current;
    }

    boolean guesserHasWon() {
        return secretWord.isRevealed();
    }

    boolean guess(String guess) {
        if (guess.length() == 1) {
            char letter = guess.charAt(0);
            return secretWord.reveal(letter) || increaseTurn();

        } else {
            return secretWord.equals(guess) || increaseTurn();
        }
    }

    private boolean increaseTurn() {
        currentTurn++;
        return false;
    }

    public String toString() {
        return "\n" + secretWord;
    }

}
