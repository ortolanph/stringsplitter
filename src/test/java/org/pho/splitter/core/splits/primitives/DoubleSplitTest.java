package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("FloatSplit Test")
public class DoubleSplitTest {

    private static final String COMMON_DATA = "2.672.67";

    private static final String EXPONENTIAL_DATA = "2e32e3";

    private static final String HEXADECIMAL_DATA = "0x1.feP-80x1.feP+8";

    private static final String SYMBOLIC_DATA = "NaNInfinity-Infinity";

    private static final String FORMATTED_DATA = "-100,895.26-100,895.26";

    private static final DecimalFormat FORMAT = new DecimalFormat("#,##0.00");

    @Test
    @DisplayName("Double simple test")
    public void shouldParseFloat() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(0, 4).split(COMMON_DATA);
        double expected = 2.67;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double simple test at end")
    public void shouldParseFloatAtEnd() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(4).split(COMMON_DATA);
        double expected = 2.67;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double exponential test")
    public void shouldParseExponentialFloat() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(0, 3).split(EXPONENTIAL_DATA);
        double expected = 2000.0f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double exponential test at end")
    public void shouldParseExponentialFloatAtEnd() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(3).split(EXPONENTIAL_DATA);
        double expected = 2000.0f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double hexadecimal test")
    public void shouldParseHexadecimalFloat() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(0, 9).split(HEXADECIMAL_DATA);
        double expected = 0.0077819824f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double hexadecimal test at end")
    public void shouldParseHexadecimalFloatAtEnd() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(9).split(HEXADECIMAL_DATA);
        double expected = 510.0f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double NaN test")
    public void shouldParseNaN() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(0, 3).split(SYMBOLIC_DATA);
        double expected = Float.NaN;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double positive infinity test")
    public void shouldParsePositiveInfinity() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(3, 11).split(SYMBOLIC_DATA);
        double expected = Float.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Double negative infinity test")
    public void shouldParseNegativeInfinity() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(11).split(SYMBOLIC_DATA);
        double expected = Float.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted double parser")
    public void shouldParseFormattedFloat() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(0, 11, FORMAT).split(FORMATTED_DATA);
        double expected = -100895.26f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted double parser at end")
    public void shouldParseFormattedFloatAtEnd() throws SplitterException {
        double actual = DoubleSplit.newDoubleSplit(11, FORMAT).split(FORMATTED_DATA);
        double expected = -100895.26f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exception test")
    public void exceptionTest() throws SplitterException {
        assertThrows(SplitterException.class, () -> DoubleSplit.newDoubleSplit(0).split(COMMON_DATA));
    }
}
