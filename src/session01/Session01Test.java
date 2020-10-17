package session01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Session01Test {

    @Test
    void run() {

    }

    @Test
    void timeOfDayToSeconds() {
        // Arrange
        final int expected = 43559;

        // Act
        Session01 t = new Session01();

        // Assert
        Assertions.assertEquals(expected, t.timeOfDayToSeconds(12, 5, 59));
    }
}