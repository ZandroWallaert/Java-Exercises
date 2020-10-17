package session04;

import java.util.Arrays;

public class SecretWord {
    private String theWord;
    private boolean[] show;

    SecretWord(String initWord) {
        theWord = initWord;
        show = new boolean[initWord.length()];
        Arrays.fill(show, false);
    }

    public String toString() {
        StringBuilder opl = new StringBuilder();

        for (int i = 0; i < theWord.length(); i++) {
            if (show[i]) {
                opl.append(theWord.charAt(i));
            } else {
                opl.append('_');
            }
        }

        return opl.toString();
    }

    boolean isRevealed() {
        for (boolean b : show) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    boolean reveal(char c) {
        boolean revealed = false;
        for (int i = 0; i < theWord.length(); i++) {
            if (!show[i] && theWord.charAt(i) == c) {
                show[i] = true;
                revealed = true;
            }

        }
        return revealed;
    }

    boolean equals(String guessWord) {
        if (theWord.equals(guessWord)) {
            Arrays.fill(show, true);
            return true;

        } else {
            return false;
        }
    }
}
