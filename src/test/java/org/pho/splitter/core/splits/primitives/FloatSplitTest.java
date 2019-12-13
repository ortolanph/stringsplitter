package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("FloatSplit Test")
class FloatSplitTest {

    private static final String COMMON_DATA = "2.672.67";

    private static final String EXPONENTIAL_DATA = "2e32e3";

    private static final String HEXADECIMAL_DATA = "0x1.feP-80x1.feP+8";

    private static final String SYMBOLIC_DATA = "NaNInfinity-Infinity";

    private static final String FORMATTED_DATA = "-100,895.26-100,895.26";

    private static final DecimalFormat FORMAT = new DecimalFormat("#,##0.00");

    @Test
    @DisplayName("Float simple test")
    public void shouldParseFloat() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(0, 4).split(COMMON_DATA);
        float expected = 2.67f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float simple test at end")
    public void shouldParseFloatAtEnd() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(4).split(COMMON_DATA);
        float expected = 2.67f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float exponential test")
    public void shouldParseExponentialFloat() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(0, 3).split(EXPONENTIAL_DATA);
        float expected = 2000.0f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float exponential test at end")
    public void shouldParseExponentialFloatAtEnd() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(3).split(EXPONENTIAL_DATA);
        float expected = 2000.0f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float hexadecimal test")
    public void shouldParseHexadecimalFloat() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(0, 9).split(HEXADECIMAL_DATA);
        float expected = 0.0077819824f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float hexadecimal test at end")
    public void shouldParseHexadecimalFloatAtEnd() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(9).split(HEXADECIMAL_DATA);
        float expected = 510.0f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float NaN test")
    public void shouldParseNaN() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(0, 3).split(SYMBOLIC_DATA);
        float expected = Float.NaN;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float positive infinity test")
    public void shouldParsePositiveInfinity() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(3, 11).split(SYMBOLIC_DATA);
        float expected = Float.POSITIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Float negative infinity test")
    public void shouldParseNegativeInfinity() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(11).split(SYMBOLIC_DATA);
        float expected = Float.NEGATIVE_INFINITY;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted float parser")
    public void shouldParseFormattedFloat() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(0, 11, FORMAT).split(FORMATTED_DATA);
        float expected = -100895.26f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Formatted float parser at end")
    public void shouldParseFormattedFloatAtEnd() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(11, FORMAT).split(FORMATTED_DATA);
        float expected = -100895.26f;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exception test")
    public void exceptionTest() throws SplitterException {
        assertThrows(SplitterException.class, () -> FloatSplit.newFloatSplit(0).split(COMMON_DATA));
    }

}
