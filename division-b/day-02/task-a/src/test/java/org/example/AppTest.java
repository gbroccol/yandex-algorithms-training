package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertEquals;

class AppTest {

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 7, 9, 0), 1),
                Arguments.of(Arrays.asList(1, 3, 3, 1, 0), 2),
                Arguments.of(Arrays.asList(1, 3, 3, 1, 0, 10, 10, 10), 2),
                Arguments.of(Arrays.asList(0, 1, 2, 3), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    public void shouldCallGetCardByIddMethod(List<Integer> numbers, int expected) {
        assertEquals(expected, App.getResult(numbers));
    }
}