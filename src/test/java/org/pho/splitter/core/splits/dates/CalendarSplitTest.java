package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CalendarSplit Test")
class CalendarSplitTest {

    private static final String DATA_1 = "14/11/2019 14:24:171573741457000";

    private static final String DATA_2 = "157374145700014/11/2019 14:24:17";

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Test
    @DisplayName("Calendar Formatted Input")
    public void calendarSplitFormattedInput() throws SplitterException, ParseException {
        Calendar actual = CalendarSplit.fromFormatted(0, 19, FORMAT).split(DATA_1);
        Calendar expected = new GregorianCalendar(2019, Calendar.NOVEMBER, 14, 14, 24, 17);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calendar Formatted Input")
    public void calendarSplitFormattedInputAtEnd() throws SplitterException {
        Calendar actual = CalendarSplit.fromFormatted(13, FORMAT).split(DATA_2);
        Calendar expected = new GregorianCalendar(2019, Calendar.NOVEMBER, 14, 14, 24, 17);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calendar Long Input")
    public void calendarSplitLongInput() throws SplitterException {
        Calendar actual = CalendarSplit.fromLong(0, 13).split(DATA_2);
        Calendar expected = new GregorianCalendar(2019, Calendar.NOVEMBER, 14, 14, 24, 17);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Calendar Long Input")
    public void calendarSplitLongInputAtEnd() throws SplitterException {
        Calendar actual = CalendarSplit.fromLong(19).split(DATA_1);
        Calendar expected = new GregorianCalendar(2019, Calendar.NOVEMBER, 14, 14, 24, 17);
        assertEquals(expected, actual);
    }
}
