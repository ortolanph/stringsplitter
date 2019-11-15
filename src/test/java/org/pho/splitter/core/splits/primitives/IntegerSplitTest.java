package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerSplitTest {

    private static final String DATA = "     483647    -483648 2147483647-2147483648    INTEGER 3000000000";

    private static final String NO_LIMIT_DATA = "     483647    -483648";

    private static final String FORMATTED_DATA = "    483,647   -483,648";

    @Test
    @DisplayName("Integer split test positive number")
    public void positiveInteger() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(0, 11).split(DATA);
        int expected = 483_647;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Integer split test negative number")
    public void negativeShort() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(11, 22).split(DATA);
        int expected = -483_648;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Integer split test max")
    public void maximumIntegerNumber() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(22, 33).split(DATA);
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Integer split test min")
    public void minimumIntegerNumber() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(33, 44).split(DATA);
        int expected = Integer.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Integer split exception String information")
    public void notAnInteger() {
        assertThrows(SplitterException.class, () -> IntegerSplit.newIntegerSplit(44, 55).split(DATA));
    }

    @Test
    @DisplayName("Integer split exception out of range")
    public void outOfRange() {
        assertThrows(SplitterException.class, () -> IntegerSplit.newIntegerSplit(55).split(DATA));
    }

    @Test
    @DisplayName("Integer split no upper limit")
    public void noLimitInteger() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(11).split(NO_LIMIT_DATA);
        int expected = -483_648;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted positive Integer split test")
    public void formattedPositiveInteger() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(0, 11, ",").split(FORMATTED_DATA);
        int expected = 483_647;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted negative Integer split test")
    public void formattedNegativeInteger() throws SplitterException {
        int actual = IntegerSplit.newIntegerSplit(11, ",").split(FORMATTED_DATA);
        int expected = -483_648;
        assertEquals(expected, actual);
    }

}