package org.example;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

class AppTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(0, 0, 0, 0),
                Arguments.of(-1, 0, 1, 3),
                Arguments.of(42, 1, 6, 6),
                Arguments.of(44, 7, 4, 1),
                Arguments.of(1, 4, 0, 3),
                Arguments.of(-3, 2, 4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void shouldCallGetCardByIddMethod(int taskCode, int iteratorCode, int checkerCode, int expected) {
        assertEquals(expected, App.getResult(taskCode, iteratorCode, checkerCode));
    }
}