package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LocalTimeSplit Test")
class LocalTimeSplitTest {

    private static final String DATA_1 = "00:40:00.1201:56:35 PM";

    private static final String DATA_2 = "01:56:35 PM00:40:00.12";

    private static final DateTimeFormatter OTHER_FORMAT = DateTimeFormatter
            .ofPattern("hh:mm:ss a");

    @Test
    @DisplayName("Simple split")
    public void localTimeSimpleSplit() throws SplitterException {
        LocalTime actual = LocalTimeSplit.newSplit(0, 11).split(DATA_1);
        LocalTime expected = LocalTime.of(0, 40, 0, 120000000);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Simple split at the end")
    public void localTimeSimpleSplitAtEnd() throws SplitterException {
        LocalTime actual = LocalTimeSplit.newLocalTimeSplit(11).split(DATA_2);
        LocalTime expected = LocalTime.of(0, 40, 0, 120000000);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test with a custom time format")
    public void localTimeCustomFormat() throws SplitterException {
        LocalTime actual = LocalTimeSplit.newLocalTimeSplit(0, 11, OTHER_FORMAT).split(DATA_2);
        LocalTime expected = LocalTime.of(13, 56, 35);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test with a custom time format")
    public void localTimeCustomFormatAtEnd() throws SplitterException {
        LocalTime actual = LocalTimeSplit.newLocalTimeSplit(11, OTHER_FORMAT).split(DATA_1);
        LocalTime expected = LocalTime.of(13, 56, 35);
        assertEquals(expected, actual);
    }
}
