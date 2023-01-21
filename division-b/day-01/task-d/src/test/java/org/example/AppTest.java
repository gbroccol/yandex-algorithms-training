package org.example;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

class AppTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 2, 3, 4}, 2),
                Arguments.of(3, new int[]{-1, 0, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void shouldCallGetCardByIddMethod(int childrenCount, int[] housesLocation, int expected) {
        assertEquals(expected, App.getResult(childrenCount, housesLocation));
    }
}