package org.pho.splitter.core.splits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringSplit Test") class StringSplitTest {

    private static final String DATA = "---StringSPLITtestArea    ";

    @Test
    @DisplayName("Simple string split test")
    public void simpleStringSplitTest() {
        String actual = StringSplit.newSplit(3, 9).split(DATA);
        String expected = "String";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("No limit String split test")
    public void noLimitStringSplitTest() {
        String actual = StringSplit.newSplit(3).split(DATA);
        String expected = "StringSPLITtestArea    ";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test lower case")
    public void stringSplitTestLower() {
        String actual = StringSplit.newSplit(9, 14, WordCase.LOWER_CASE).split(DATA);
        String expected = "split";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test upper case")
    public void stringSplitTestUpper() {
        String actual = StringSplit.newSplit(14, 18, WordCase.UPPER_CASE).split(DATA);
        String expected = "TEST";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test upper case")
    public void stringSplitTestNoCase() {
        String actual = StringSplit.newSplit(18, 22, WordCase.NO_CASE).split(DATA);
        String expected = "Area";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test trim")
    public void stringSplitTrim() {
        String actual = StringSplit.newSplit(18, 26, true).split(DATA);
        String expected = "Area";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test lower case")
    public void noLimitstringSplitTestLower() {
        String actual = StringSplit.newSplit(3, WordCase.LOWER_CASE).split(DATA);
        String expected = "stringsplittestarea    ";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("No limit string split test upper case")
    public void noLimitStringSplitTestUpper() {
        String actual = StringSplit.newSplit(3, WordCase.UPPER_CASE).split(DATA);
        String expected = "STRINGSPLITTESTAREA    ";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("No limit string split test upper case")
    public void noLimitStringSplitTestNoCase() {
        String actual = StringSplit.newSplit(3, WordCase.NO_CASE).split(DATA);
        String expected = "StringSPLITtestArea    ";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test trim")
    public void noLimitStringSplitTrim() {
        String actual = StringSplit.newSplit(3, true).split(DATA);
        String expected = "StringSPLITtestArea";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test trim")
    public void stringSplitTrimUpperCase() {
        String actual = StringSplit.newSplit(18, WordCase.UPPER_CASE, true).split(DATA);
        String expected = "AREA";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test trim")
    public void stringSplitTrimLowerCase() {
        String actual = StringSplit.newSplit(18, WordCase.LOWER_CASE, true).split(DATA);
        String expected = "area";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("String split test trim")
    public void stringSplitTrimNoCase() {
        String actual = StringSplit.newSplit(18, WordCase.NO_CASE, true).split(DATA);
        String expected = "Area";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("All parameters test")
    public void stringSplitAllParametersTest() {
        String actual = StringSplit.newSplit(18, 26, WordCase.NO_CASE, true).split(DATA);
        String expected = "Area";
        assertEquals(expected, actual);
    }
}
