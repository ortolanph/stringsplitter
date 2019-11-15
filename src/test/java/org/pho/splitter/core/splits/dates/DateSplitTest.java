package org.pho.splitter.core.splits.dates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.exception.SplitterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateSplitTest {

    private static final String DATA_1 = "14/11/2019 14:24:171573741457000";

    private static final String DATA_2 = "157374145700014/11/2019 14:24:17";

    private static final String MY_DATE = "14/11/2019 14:24:17";

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Test
    @DisplayName("DateSplit Formatted Input")
    public void dateSplitFormattedInput() throws SplitterException, ParseException {
        Date actual = DateSplit.fromFormatted(0, 19, FORMAT).split(DATA_1);
        Date expected = FORMAT.parse(MY_DATE);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("DateSplit Formatted Input at end")
    public void dateSplitFormattedInputAtEnd() throws SplitterException, ParseException  {
        Date actual = DateSplit.fromFormatted(13, FORMAT).split(DATA_2);
        Date expected = FORMAT.parse(MY_DATE);
        System.out.println(expected.getTime());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("DateSplit Long Input")
    public void dateSplitLongInput() throws SplitterException, ParseException {
        Date actual = DateSplit.fromLong(0, 13).split(DATA_2);
        Date expected = FORMAT.parse(MY_DATE);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("DateSplit Long Input at end")
    public void dateSplitLongInputAtEnd() throws SplitterException, ParseException {
        Date actual = DateSplit.fromLong(19).split(DATA_1);
        Date expected = FORMAT.parse(MY_DATE);
        assertEquals(expected, actual);
    }
}
