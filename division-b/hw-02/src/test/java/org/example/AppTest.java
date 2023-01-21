package org.example;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

class AppTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(100, 5, 6, 0),
                Arguments.of(10, 1, 9, 1),
                Arguments.of(100, 1, 100, 0),
                Arguments.of(100, 5, 100, 4),
                Arguments.of(50, 5, 7, 1),
                Arguments.of(10, 9, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void shouldCallGetCardByIddMethod(int stationsNumber, int start, int finish, int expected) {
        assertEquals(expected, App.getResult(stationsNumber, start, finish));
    }
}