package org.pho.splitter.core.splits;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import static org.junit.jupiter.api.Assertions.*;

class LongSplitTest {

    private static final String DATA = "         36854775807        -36854775808 9223372036854775807-9223372036854775808LONG NUMBER INDEED!! 9300000000000000000";

    private static final String NO_LIMIT_DATA = "         36854775807        -36854775808";

    private static final String FORMATTED_DATA = "      36,854,775,807     -36,854,775,808";

    @Test
    @Disabled
    @DisplayName("Long split test positive number")
    public void positiveLong() throws SplitterException {
        long actual = LongSplit.newLongSplit(0, 11).split(DATA);
        long expected = 36_854_775_807L;
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Long split test negative number")
    public void negativeShort() throws SplitterException {
        long actual = LongSplit.newLongSplit(11, 22).split(DATA);
        long expected = -36_854_775_808L;
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Long split test max")
    public void maximumLongNumber() throws SplitterException {
        long actual = LongSplit.newLongSplit(22, 33).split(DATA);
        long expected = Long.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Long split test min")
    public void minimumLongNumber() throws SplitterException {
        long actual = LongSplit.newLongSplit(33, 44).split(DATA);
        long expected = Long.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Long split exception String information")
    public void notAnLong() {
        assertThrows(SplitterException.class, () -> LongSplit.newLongSplit(44, 55).split(DATA));
    }

    @Test
    @Disabled
    @DisplayName("Long split exception out of range")
    public void outOfRange() {
        assertThrows(SplitterException.class, () -> LongSplit.newLongSplit(55).split(DATA));
    }

    @Test
    @Disabled
    @DisplayName("Long split no upper limit")
    public void noLimitLong() throws SplitterException {
        long actual = LongSplit.newLongSplit(11).split(NO_LIMIT_DATA);
        long expected = -36_854_775_808L;
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Formatted positive Long split test")
    public void formattedPositiveLong() throws SplitterException {
        long actual = LongSplit.newLongSplit(0, 11, ",").split(FORMATTED_DATA);
        long expected = 36_854_775_807L;
        assertEquals(expected, actual);
    }

    @Test
    @Disabled
    @DisplayName("Formatted negative Long split test")
    public void formattedNegativeLong() throws SplitterException {
        long actual = LongSplit.newLongSplit(11, ",").split(FORMATTED_DATA);
        long expected = -36_854_775_808L;
        assertEquals(expected, actual);
    }

}