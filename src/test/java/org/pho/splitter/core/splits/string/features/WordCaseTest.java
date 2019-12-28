package org.pho.splitter.core.splits.string.features;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Word case test")
class WordCaseTest {

    @Test
    @DisplayName("Upper case test")
    public void shouldReturnUpperCaseString() {
        String actual = WordCase.UPPER_CASE.apply("test");
        String expected = "TEST";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Lower case test")
    public void shouldReturnLowerCaseString() {
        String actual = WordCase.LOWER_CASE.apply("TEST");
        String expected = "test";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("No modifications test")
    public void shouldReturNotModifiedString() {
        String actual = WordCase.NO_CASE.apply("Test");
        String expected = "Test";
        assertEquals(expected, actual);
    }
}