package org.pho.splitter.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.beans.StringSplit;
import org.pho.splitter.core.splitters.StringArraySplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StringArraySplitter test") class StringArraySplitterTest {

    private static final String DATA = "1STRING SPLITTER     JAVA8     POM       JAR       1.0.0   ";

    private StringArraySplitter splitter;

    @BeforeEach
    @DisplayName("Instantiating a splitter")
    public void setUp() {
        splitter = new StringArraySplitter();
    }

    @AfterEach
    @DisplayName("Recycling a splitter")
    public void tearDown() {
        splitter = null;
    }

    @Test
    @DisplayName("Testing split adding")
    public void addSplitterTest() {
        StringSplit expectedStringSplit1 = StringSplit.newSplit(1, 1);
        StringSplit expectedStringSplit2 = StringSplit.newSplit(2);

        splitter.addSplit(expectedStringSplit1);
        splitter.addSplit(expectedStringSplit2);

        List<StringSplit> actualStringSplits = splitter.getSplitters();

        assertTrue(actualStringSplits.containsAll(Arrays.asList(expectedStringSplit1, expectedStringSplit2)));
    }

    @Test
    @DisplayName("Testing the split method")
    public void splitTest() {
        List<String> expected =
            new ArrayList<>(Arrays.asList(
                "1",
                "STRING SPLITTER     ",
                "JAVA8     ",
                "POM       ",
                "JAR       ",
                "1.0.0   "
            ));

        splitter.addSplit(StringSplit.newSplit(0, 1));
        splitter.addSplit(StringSplit.newSplit(1, 21));
        splitter.addSplit(StringSplit.newSplit(21, 31));
        splitter.addSplit(StringSplit.newSplit(31, 41));
        splitter.addSplit(StringSplit.newSplit(41, 51));
        splitter.addSplit(StringSplit.newSplit(51));

        List<String> actual = splitter.split(DATA);

        assertEquals(expected, actual);
    }
}
