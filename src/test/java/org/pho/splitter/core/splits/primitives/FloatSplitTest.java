package org.pho.splitter.core.splits.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FloatSplit Test")
public class FloatSplitTest {

    private static final String COMMON_DATA = "2.672.67";

    private static final String EXPONENTIAL_DATA = "2e32e3";

    private static final String FORMATTED_DATA = "-100,895.26-100,895.26";

    private static final String BINARY_DATA = "0x1.feP-80x1.feP+8";

    private static final String SYMBOLIC_DATA = "NaNInfinity-Infinity";

    private static final DecimalFormat FORMAT = new DecimalFormat("#,##0.00");

    @Test
    @DisplayName("Float simple test")
    public void shouldParseFloat() throws SplitterException {
        float actual = FloatSplit.newFloatSplit(0, 4).split(COMMON_DATA);
        float expected = 2.67f;
        assertEquals(expected, actual);
    }
}
