package org.example;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

class AppTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(5, 1, 1, 0),
                Arguments.of(3, -1, -1, 1),
                Arguments.of(4, 4, 4, 2),
                Arguments.of(4, 2, 2, 0),
                Arguments.of(5, 0, 0, 0),
                Arguments.of(5, -1, -1, 1),
                Arguments.of(5, 4, 0, 0),
                Arguments.of(5, 0, 0, 0),
                Arguments.of(0, 0, 0, 0),
                Arguments.of(-5, 1, 1, 1),
                Arguments.of(-5, -1, -1, 0),
                Arguments.of(0, 1, 1, 1),
                Arguments.of(0, -1, 1, 1),
                Arguments.of(5, 0, 0, 0),
                Arguments.of(5, 2, 0, 0),
                Arguments.of(5, 5, 0, 0),
                Arguments.of(5, 3, 2, 0),
                Arguments.of(5, 0, 5, 0),
                Arguments.of(5, 0, 2, 0),
                Arguments.of(5, 7, 0, 2),
                Arguments.of(5, 5, 2, 2),
                Arguments.of(5, 0, 6, 3),
                Arguments.of(5, -1, 5, 3),
                Arguments.of(5, -1, 2, 1),
                Arguments.of(5, -1, 0, 1),
                Arguments.of(5, -1, -1, 1),
                Arguments.of(5, 0, -1, 1),
                Arguments.of(5, 1, -1, 1),
                Arguments.of(-5, 0, 0, 0),
                Arguments.of(-5, 0, -2, 0),
                Arguments.of(-5, 0, -5, 0),
                Arguments.of(-5, -2, -3, 0),
                Arguments.of(-5, -5, 0, 0),
                Arguments.of(-5, -2, 0, 0),
                Arguments.of(-5, -1, -1, 0),
                Arguments.of(-5, -1, 1, 1),
                Arguments.of(-5, 0, 1, 1),
                Arguments.of(-5, 1, 1, 1),
                Arguments.of(-5, 1, -1, 1),
                Arguments.of(-5, 1, -4, 3),
                Arguments.of(-5, 1, -5, 3),
                Arguments.of(-5, 1, -6, 3),
                Arguments.of(-5, 0, -6, 3),
                Arguments.of(-5, -1, -6, 3),
                Arguments.of(-5, -1, -5, 3),
                Arguments.of(-5, -5, -1, 2),
                Arguments.of(-5, -6, -1, 2),
                Arguments.of(-5, -6, 0, 2),
                Arguments.of(-5, -6, 1, 2),
                Arguments.of(-5, -5, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void shouldCallGetCardByIddMethod(int d, int x1, int x2, int expected) {
        assertEquals(expected, App.getResult(d, x1, x2));
    }
}