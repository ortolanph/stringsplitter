package org.pho.splitter.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.beans.WordCase;
import org.pho.splitter.core.builders.StringSplitterBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringSplitterBuilder test") class StringSplitterBuilderTest {

    private static final String DATA = "1STRING SPLITTER     JAVA8     POM       JAR       1.0.0   ";

    @Test
    @DisplayName("Builder Test")
    public void buildTest() {
        List<String> expected =
            new ArrayList<>(Arrays.asList(
                "1",
                "STRING SPLITTER     ",
                "JAVA8     ",
                "POM       ",
                "JAR       ",
                "1.0.0   "
            ));

        List<String> actual =
            StringSplitterBuilder
                .newSplitter()
                .addStringSplit(0, 1)
                .addStringSplit(1, 21)
                .addStringSplit(21, 31)
                .addStringSplit(31, 41)
                .addStringSplit(41, 51)
                .addStringSplit(51)
                .build()
                .split(DATA);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Builder Test with WordCase")
    public void buildTestWordCase() {
        List<String> expected =
            new ArrayList<>(Arrays.asList(
                "1",
                "STRING SPLITTER     ",
                "JAVA8     ",
                "pom       ",
                "jar       ",
                "1.0.0   "
            ));

        List<String> actual =
            StringSplitterBuilder
                .newSplitter()
                .addStringSplit(0, 1)
                .addStringSplit(1, 21)
                .addStringSplit(21, 31, WordCase.UPPER_CASE)
                .addStringSplit(31, 41, WordCase.LOWER_CASE)
                .addStringSplit(41, 51, WordCase.LOWER_CASE)
                .addStringSplit(51)
                .build()
                .split(DATA);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Builder Test with Trim")
    public void buildTestTrimmed() {
        List<String> expected =
            new ArrayList<>(Arrays.asList(
                "1",
                "STRING SPLITTER",
                "JAVA8",
                "POM",
                "JAR",
                "1.0.0"
            ));

        List<String> actual =
            StringSplitterBuilder
                .newSplitter()
                .addStringSplit(0, 1)
                .addStringSplit(1, 21, true)
                .addStringSplit(21, 31, true)
                .addStringSplit(31, 41, true)
                .addStringSplit(41, 51, true)
                .addStringSplit(51, true)
                .build()
                .split(DATA);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Builder Test with WordCase and Trim")
    public void buildTestWordCaseTrimmed() {
        List<String> expected =
            new ArrayList<>(Arrays.asList(
                "1",
                "STRING SPLITTER",
                "JAVA8",
                "pom",
                "jar",
                "1.0.0"
            ));

        List<String> actual =
            StringSplitterBuilder
                .newSplitter()
                .addStringSplit(0, 1)
                .addStringSplit(1, 21, true)
                .addStringSplit(21, 31, true)
                .addStringSplit(31, 41, WordCase.LOWER_CASE, true)
                .addStringSplit(41, 51, WordCase.LOWER_CASE, true)
                .addStringSplit(51, true)
                .build()
                .split(DATA);

        assertEquals(expected, actual);
    }

}
