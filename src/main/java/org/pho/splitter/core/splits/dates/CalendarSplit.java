package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Converts a String split into a <strong>Calendar</strong> object.
 *
 * @author Paulo Henrique Ortolan
 */
public class CalendarSplit extends AbstractSplitter<Calendar> {

    private SimpleDateFormat format;

    private CalendarSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into an Calendar from a formatted source.
     *
     * @param start  where the split starts
     * @param end    where the split ends
     * @param format the date format
     * @return an instance of CalendarSplit
     */
    public static CalendarSplit fromFormatted(int start, int end, SimpleDateFormat format) {
        CalendarSplit calendarSplit = new CalendarSplit(start, end);
        calendarSplit.format = format;
        return calendarSplit;
    }

    /**
     * Adds a String conversion into an Calendar from a formatted source.
     *
     * @param start  where the split starts
     * @param format the date format
     * @return an instance of CalendarSplit
     */
    public static CalendarSplit fromFormatted(int start, SimpleDateFormat format) {
        CalendarSplit calendarSplit = new CalendarSplit(start, END_OF_LINE);
        calendarSplit.format = format;
        return calendarSplit;
    }

    /**
     * Adds a String conversion into a Calendar from a long value representing a date.
     *
     * @param start  where the split starts
     * @param end    where the split ends
     * @return an instance of CalendarSplit
     */
    public static CalendarSplit fromLong(int start, int end) {
        return new CalendarSplit(start, end);
    }

    /**
     * Adds a String conversion into a Calendar from a long value representing a date.
     *
     * @param start  where the split starts
     * @return an instance of CalendarSplit
     */
    public static CalendarSplit fromLong(int start) {
        return new CalendarSplit(start, END_OF_LINE);
    }

    /**
     * Splits the String source into an Calendar.
     *
     * @param source the String source
     * @return a Calendar instance from a String
     * @throws SplitterException when the conversion goes wrong
     */
    @Override
    public Calendar split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);
        Calendar splitted = null;

        try {
            splitted = (format == null) ?
                    convertTime(Long.valueOf(result)) :
                    convertString(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return splitted;
    }

    private Calendar convertTime(long time) {
        return createCalendarFromDate(new Date(time));
    }

    private Calendar convertString(String time) throws ParseException {
        return createCalendarFromDate(format.parse(time));
    }

    private Calendar createCalendarFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
