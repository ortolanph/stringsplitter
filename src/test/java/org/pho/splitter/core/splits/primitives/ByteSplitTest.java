package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ByteSplitTest {

    private static final String DATA = "  65 -65 127-128BYTE 999";

    private static final String NO_LIMIT_DATA = "  65  -65";

    @Test
    @DisplayName("Byte split test positive number")
    public void positiveByte() throws SplitterException {
        byte actual = ByteSplit.newByteSplit(0, 4).split(DATA);
        byte expected = 65;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Byte split test negative number")
    public void negativeByte() throws SplitterException {
        byte actual = ByteSplit.newByteSplit(4, 8).split(DATA);
        byte expected = -65;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Byte split test max")
    public void maximumByteNumber() throws SplitterException {
        byte actual = ByteSplit.newByteSplit(8, 12).split(DATA);
        byte expected = Byte.MAX_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Byte split test min")
    public void minimumByteNumber() throws SplitterException {
        byte actual = ByteSplit.newByteSplit(12, 16).split(DATA);
        byte expected = Byte.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Byte split exception String information")
    public void notAByte() {
        assertThrows(SplitterException.class, () -> ByteSplit.newByteSplit(16, 20).split(DATA));
    }

    @Test
    @DisplayName("Byte split exception out of range")
    public void outOfRange() {
        assertThrows(SplitterException.class, () -> ByteSplit.newByteSplit(20).split(DATA));
    }

    @Test
    @DisplayName("Byte split no upper limit")
    public void noLimitByte() throws SplitterException {
        byte actual = ByteSplit.newByteSplit(4).split(NO_LIMIT_DATA);
        byte expected = -65;
        assertEquals(expected, actual);
    }

}
