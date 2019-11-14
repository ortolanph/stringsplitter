package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LocalDateTimeSplit Test")
class LocalDateTimeSplitTest {

    private static final String DATA_1 = "2019-11-14T11:17:39.049Thursday, 14 November 2019, 11:17";

    private static final String DATA_2 = "Thursday, 14 November 2019, 11:172019-11-14T11:17:39.049";

    private static final DateTimeFormatter OTHER_FORMAT = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm");

    @Test
    @DisplayName("LocalDateTimeSplit simple split")
    public void shouldSplitSimpleLocalDateTime() throws SplitterException {
        LocalDateTime actual = LocalDateTimeSplit.newLocalDateTimeSplit(0, 23).split(DATA_1);
        LocalDate localDate = LocalDate.of(2019, Month.NOVEMBER, 14);
        LocalTime localTime = LocalTime.of(11,17,39, 49000000);
        LocalDateTime expected = LocalDateTime.of(localDate, localTime);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("LocalDateTimeSplit simple split at end")
    public void shouldSplitSimpleLocalDateTimeAtEnd() throws SplitterException {
        LocalDateTime actual = LocalDateTimeSplit.newLocalDateTimeSplit(33).split(DATA_2);
        LocalDate localDate = LocalDate.of(2019, Month.NOVEMBER, 14);
        LocalTime localTime = LocalTime.of(11,17,39, 49000000);
        LocalDateTime expected = LocalDateTime.of(localDate, localTime);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("LocalDateTimeSplit custom split")
    public void shouldSplitCustomLocalDateTime() throws SplitterException {
        LocalDateTime actual = LocalDateTimeSplit.newLocalDateTimeSplit(0,33, OTHER_FORMAT ).split(DATA_2);
        LocalDate localDate = LocalDate.of(2019, Month.NOVEMBER, 14);
        LocalTime localTime = LocalTime.of(11,17);
        LocalDateTime expected = LocalDateTime.of(localDate, localTime);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("LocalDateTimeSplit custom split at end")
    public void shouldSplitCustomLocalDateTimeAtEnd() throws SplitterException {
        LocalDateTime actual = LocalDateTimeSplit.newLocalDateTimeSplit(23, OTHER_FORMAT).split(DATA_1);
        LocalDate localDate = LocalDate.of(2019, Month.NOVEMBER, 14);
        LocalTime localTime = LocalTime.of(11,17);
        LocalDateTime expected = LocalDateTime.of(localDate, localTime);
        assertEquals(expected, actual);
    }
}
