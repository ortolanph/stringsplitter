package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Converts a String split into a <strong>LocalDateTime</strong> object.
 *
 * @author Paulo Henrique Ortolan
 */
public final class LocalDateTimeSplit extends AbstractSplitter<LocalDateTime> {

    private DateTimeFormatter format;

    private LocalDateTimeSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into a LocalDateTime.
     *
     * @param start where the split starts
     * @param end   where the split ends
     * @return an instance of LocalDateSplit
     */
    public static LocalDateTimeSplit newLocalDateTimeSplit(int start, int end) {
        return new LocalDateTimeSplit(start, end);
    }

    /**
     * Adds a String conversion into a LocalDateTime.
     *
     * @param start where the split starts
     * @return an instance of LocalDateSplit
     */
    public static LocalDateTimeSplit newLocalDateTimeSplit(int start) {
        return new LocalDateTimeSplit(start, END_OF_LINE);
    }

    /**
     * Adds a String conversion into a LocalDateTime from a formatted source.
     *
     * @param start  where the split starts
     * @param end    where the split ends
     * @param format the date format
     * @return an instance of LocalDateTimeSplit
     */
    public static LocalDateTimeSplit fromFormat(int start, int end, DateTimeFormatter format) {
        LocalDateTimeSplit localDateTimeSplit = new LocalDateTimeSplit(start, end);
        localDateTimeSplit.format = format;
        return localDateTimeSplit;
    }

    /**
     * Adds a String conversion into a LocalDateTime from a formatted source.
     *
     * @param start  where the split starts
     * @param format the date format
     * @return an instance of LocalDateTimeSplit
     */
    public static LocalDateTimeSplit fromFormat(int start, DateTimeFormatter format) {
        LocalDateTimeSplit localDateTimeSplit = new LocalDateTimeSplit(start, END_OF_LINE);
        localDateTimeSplit.format = format;
        return localDateTimeSplit;
    }

    /**
     * Splits the String source into an LocalDateTime.
     *
     * @param source the String source
     * @return a LocalDateTime instance from a String
     */
    @Override
    public LocalDateTime split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharactersAndSplit(result);

        try {
            return (format == null) ? LocalDateTime.parse(result) : LocalDateTime.parse(result, format);
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
