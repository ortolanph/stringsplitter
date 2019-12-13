package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Converts a String split into a <strong>LocalDate</strong> object.
 *
 * @author Paulo Henrique Ortolan
 */
public final class LocalDateSplit extends AbstractSplitter<LocalDate> {

    private DateTimeFormatter format;

    private LocalDateSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into a LocalDate.
     *
     * @param start where the split starts
     * @param end   where the split ends
     * @return an instance of LocalDateSplit
     */
    public static LocalDateSplit newLocalDateSplit(int start, int end) {
        return new LocalDateSplit(start, end);
    }

    /**
     * Adds a String conversion into a LocalDate.
     *
     * @param start where the split starts
     * @return an instance of LocalDateSplit
     */
    public static LocalDateSplit newLocalDateSplit(int start) {
        return new LocalDateSplit(start, END_OF_LINE);
    }

    /**
     * Adds a String conversion into a LocalDate from a formatted source.
     *
     * @param start  where the split starts
     * @param end    where the split ends
     * @param format the date format
     * @return an instance of LocalDateSplit
     */
    public static LocalDateSplit fromFormatted(int start, int end, DateTimeFormatter format) {
        LocalDateSplit localDateSplit = newLocalDateSplit(start, end);
        localDateSplit.format = format;
        return localDateSplit;
    }

    /**
     * Adds a String conversion into a LocalDate from a formatted source.
     *
     * @param start  where the split starts
     * @param format the date format
     * @return an instance of LocalDateSplit
     */
    public static LocalDateSplit fromFormatted(int start, DateTimeFormatter format) {
        return fromFormatted(start, END_OF_LINE, format);
    }

    /**
     * Splits the String source into an LocalDate.
     *
     * @param source the String source
     * @return a LocalDate instance from a String
     */
    @Override
    public LocalDate split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        try {
            return (format == null) ? LocalDate.parse(result) : LocalDate.parse(result, format);
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }

    }
}