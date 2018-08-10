package org.pho.splitter.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                .addSplit(0, 1)
                .addSplit(1, 21)
                .addSplit(21, 31)
                .addSplit(31, 41)
                .addSplit(41, 51)
                .addSplit(51)
                .build()
                .split(DATA);

        assertEquals(expected, actual);
    }

}
