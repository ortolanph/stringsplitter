package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("LocalDateSplit Test")
class LocalDateSplitTest {

    private static final String DATA_1 = "1977-12-1414/12/1977";

    private static final String DATA_2 = "14/12/19771977-12-14";

    private static final char SEPARATOR = '/';

    private static final DateTimeFormatter OTHER_FORMAT = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral(SEPARATOR)
            .appendValue((ChronoField.MONTH_OF_YEAR), 2)
            .appendLiteral(SEPARATOR)
            .appendValue(ChronoField.YEAR, 2, 4, SignStyle.NEVER)
            .toFormatter();

    @Test
    @DisplayName("Simple split")
    public void localDateSimpleSplit() throws SplitterException {
        LocalDate actual = LocalDateSplit.newLocalDateSplit(0, 10).split(DATA_1);
        LocalDate expected = LocalDate.of(1977, Month.DECEMBER, 14);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Simple split at the end")
    public void localDateSimpleSplitAtEnd() throws SplitterException {
        LocalDate actual = LocalDateSplit.newLocalDateSplit(10).split(DATA_2);
        LocalDate expected = LocalDate.of(1977, Month.DECEMBER, 14);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test with a custom date format")
    public void localDateCustomizedFormat() throws SplitterException {
        LocalDate actual = LocalDateSplit.fromFormatted(0, 10, OTHER_FORMAT).split(DATA_2);
        LocalDate expected = LocalDate.of(1977, Month.DECEMBER, 14);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test with a custom date format at end")
    public void localDateCustomizedFormatAtEnd() throws SplitterException {
        LocalDate actual = LocalDateSplit.fromFormatted(10, OTHER_FORMAT).split(DATA_1);
        LocalDate expected = LocalDate.of(1977, Month.DECEMBER, 14);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exception test")
    public void shouldThrowException() {
        assertThrows(SplitterException.class, () -> { LocalDateSplit.newLocalDateSplit(0).split(DATA_1); });
    }
}