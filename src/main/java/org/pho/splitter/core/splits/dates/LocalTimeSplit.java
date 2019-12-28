package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Converts a String split into a <strong>LocalTime</strong> object.
 *
 * @author Paulo Henrique Ortolan
 */
public final class LocalTimeSplit extends AbstractSplitter<LocalTime> {

    private DateTimeFormatter format;

    private LocalTimeSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into a LocalTime.
     *
     * @param start where the split starts
     * @param end   where the split ends
     * @return an instance of LocalTimeplit
     */
    public static LocalTimeSplit newLocalTimeSplit(int start, int end) {
        return new LocalTimeSplit(start, end);
    }

    /**
     * Adds a String conversion into a LocalTime.
     *
     * @param start where the split starts
     * @return an instance of LocalTimeplit
     */
    public static LocalTimeSplit newLocalTimeSplit(int start) {
        return new LocalTimeSplit(start, END_OF_LINE);
    }

    /**
     * Adds a String conversion into a LocalTime from a formatted source.
     *
     * @param start  where the split starts
     * @param end    where the split ends
     * @param format the date format
     * @return an instance of LocalTimeplit
     */
    public static LocalTimeSplit fromFormatted(int start, int end, DateTimeFormatter format) {
        LocalTimeSplit timeSplit = new LocalTimeSplit(start, end);
        timeSplit.format = format;
        return timeSplit;
    }

    /**
     * Adds a String conversion into a LocalTime from a formatted source.
     *
     * @param start  where the split starts
     * @param format the date format
     * @return an instance of LocalTimeplit
     */
    public static LocalTimeSplit fromFormatted(int start, DateTimeFormatter format) {
        LocalTimeSplit timeSplit = new LocalTimeSplit(start, END_OF_LINE);
        timeSplit.format = format;
        return timeSplit;
    }

    /**
     * Splits the String source into an LocalTime.
     *
     * @param source the String source
     * @return a LocalTime instance from a String
     */
    @Override
    public LocalTime split(String source) throws SplitterException {
        String result = simpleSplit(source);

        try {
            return (format == null) ? LocalTime.parse(result) : LocalTime.parse(result, format);
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
