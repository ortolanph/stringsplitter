package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.primitives.ShortSplit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShortSplitTest {

    private static final String DATA = "  1500 -1500 32767-32768SHORT 50000";

    private static final String NO_LIMIT_DATA = "  1500 -1500";

    private static final String FORMATTED_DATA = " 23,500-23,500";

    @Test
    @DisplayName("Short split test positive number")
    public void positiveShort() throws SplitterException {
        short actual = ShortSplit.newShortSplit(0, 6).split(DATA);
        short expected = 1_500;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Short split test negative number")
    public void negativeShort() throws SplitterException {
        short actual = ShortSplit.newShortSplit(6, 12).split(DATA);
        short expected = -1_500;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Short split test max")
    public void maximumShortNumber() throws SplitterException {
        short actual = ShortSplit.newShortSplit(12, 18).split(DATA);
        short expected = Short.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Short split test min")
    public void minimumShortNumber() throws SplitterException {
        short actual = ShortSplit.newShortSplit(18, 24).split(DATA);
        short expected = Short.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Short split exception String information")
    public void notAShort() {
        assertThrows(SplitterException.class, () -> ShortSplit.newShortSplit(24, 30).split(DATA));
    }

    @Test
    @DisplayName("Short split exception out of range")
    public void outOfRange() {
        assertThrows(SplitterException.class, () -> ShortSplit.newShortSplit(30).split(DATA));
    }

    @Test
    @DisplayName("Short split no upper limit")
    public void noLimitShort() throws SplitterException {
        short actual = ShortSplit.newShortSplit(6).split(NO_LIMIT_DATA);
        short expected = -1_500;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted positive Short split test")
    public void formattedPositiveShort() throws SplitterException {
        short actual = ShortSplit.newShortSplit(0, 7, ",").split(FORMATTED_DATA);
        short expected = 23500;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted negative Short split test")
    public void formattedNegativeShort() throws SplitterException {
        short actual = ShortSplit.newShortSplit(7, ",").split(FORMATTED_DATA);
        short expected = -23500;
        assertEquals(expected, actual);
    }

}
