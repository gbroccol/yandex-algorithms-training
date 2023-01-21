package org.example;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

class AppTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1, 2, 2003, 0),
                Arguments.of(2, 29, 2008, 1),
                Arguments.of(1, 1, 2008, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void shouldCallGetCardByIddMethod(int stationsNumber, int start, int finish, int expected) {
        assertEquals(expected, App.getResult(stationsNumber, start, finish));
    }
}