package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Converts a String split into a <strong>Date</strong> object.
 *
 * @author Paulo Henrique Ortolan
 */
public final class DateSplit extends AbstractSplitter<Date> {

    private SimpleDateFormat format;

    private DateSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into an Calendar from a formatted source.
     *
     * @param start  where the split starts
     * @param end    where the split ends
     * @param format the date format
     * @return an instance of DateSplit
     */
    public static DateSplit fromFormatted(int start, int end, SimpleDateFormat format) {
        DateSplit dateSplit = new DateSplit(start, end);
        dateSplit.format = format;
        return dateSplit;
    }

    /**
     * Adds a String conversion into a Date from a formatted source.
     *
     * @param start  where the split starts
     * @param format the date format
     * @return an instance of DateSplit
     */
    public static DateSplit fromFormatted(int start, SimpleDateFormat format) {
        return fromFormatted(start, END_OF_LINE, format);
    }

    /**
     * Adds a String conversion into a Date from a long value representing a date.
     *
     * @param start where the split starts
     * @param end   where the split ends
     * @return an instance of DateSplit
     */
    public static DateSplit fromLong(int start, int end) {
        return new DateSplit(start, end);
    }

    /**
     * Adds a String conversion into an Calendar from a long value representing a date.
     *
     * @param start where the split starts
     * @return an instance of DateSplit
     */
    public static DateSplit fromLong(int start) {
        return new DateSplit(start, END_OF_LINE);
    }


    /**
     * Splits the String source into an Date.
     *
     * @param source the String source
     * @return a Date instance from a String
     * @throws SplitterException when the conversion goes wrong
     */
    @Override
    public Date split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharactersAndSplit(result);
        Date splitted = null;

        try {
            splitted = (format == null) ?
                    new Date(Long.valueOf(result)) :
                    format.parse(result);
        } catch (ParseException e) {
            throw new SplitterException(e.getMessage(), e);
        }

        return splitted;
    }
}
