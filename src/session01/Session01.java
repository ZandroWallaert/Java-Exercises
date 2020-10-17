package session01;

import java.util.Arrays;

public class Session01 {
    public static void main(String[] args) {
        new Session01().run();
    }

    // De start functie
    private void run() {
// Hier komt alle "start"-code
        line(10, false, 5, 'x');
        rectangle(5, 10, false, 3, 'x');
        int secondsSinceMidnight = timeOfDayToSeconds(12, 5, 59);
        System.out.println(secondsSinceMidnight);
        int[] timeOfDay = secondsToTimeOfDay(secondsSinceMidnight);
        System.out.println(Arrays.toString(timeOfDay));
    }

    // Hier komen alle functies
    private void line(int l, boolean fill, int indentation, char symbol) {
        String space = " ";
        String spaced = "";
        for (int i = 0; i < l - 2; i++) {
            spaced += space;
        }
        if (!fill) {
            for (int j = 0; j < indentation; j++) {
                System.out.print(" ");
            }
            System.out.println(symbol + spaced + symbol);
        } else {
            for (int j = 0; j < indentation; j++) {
                System.out.print(" ");
            }
            for (int i = 0; i < l; i++) {
                System.out.print(symbol);
            }
        }
    }

    private void rectangle(int h, int b, boolean fill, int indentation, char symbol) {
        String space = " ";
        String spaced = "";
        char symbolchar = symbol;
        String symbolized = "";
        for (int i = 0; i < b - 2; i++) {
            spaced += space;
        }
        for (int i = 0; i < b; i++) {
            symbolized += symbolchar;
        }
        for (int j = 0; j < indentation; j++) {
            System.out.print(" ");
        }
        for (int i = 0; i < b; i++) {
            System.out.print(symbol);
        }
        System.out.println("");
        if (!fill) {
            for (int i = 0; i < (h - 2); i++) {
                for (int j = 0; j < indentation; j++) {
                    System.out.print(" ");
                }
                System.out.println(symbol + spaced + symbol);
            }
        } else {
            for (int i = 0; i < h - 2; i++) {
                for (int j = 0; j < indentation; j++) {
                    System.out.print(" ");
                }
                System.out.println(symbolized);
            }
        }
        for (int j = 0; j < indentation; j++) {
            System.out.print(" ");
        }
        for (int i = 0; i < b; i++) {
            System.out.print(symbol);
        }
        System.out.println("");
    }

    int timeOfDayToSeconds(int hours, int minutes, int seconds) {
        int hourToSeconds = ((hours) * 60) * 60;
        int minuteToSeconds = minutes * 60;
        return (hourToSeconds + minuteToSeconds + seconds);
    }

    int[] secondsToTimeOfDay(int n) {
        int h = (n / 3600);
        int m = (n / 60) % 60;
        int s = n % 60;
        int[] res = new int[3];
        res[0] = s;
        res[1] = m;
        res[2] = h;
        return res;
    }

}

