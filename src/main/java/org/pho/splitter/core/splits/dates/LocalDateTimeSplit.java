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
public class LocalDateTimeSplit extends AbstractSplitter<LocalDateTime> {

    private DateTimeFormatter formatter;

    private LocalDateTimeSplit(int start, int end) {
        super(start, end);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public static LocalDateTimeSplit newLocalDateTimeSplit(int start, int end) {
        return new LocalDateTimeSplit(start, end);
    }

    /**
     *
     * @param start
     * @param end
     * @param formatter
     * @return
     */
    public static LocalDateTimeSplit newLocalDateTimeSplit(int start, int end, DateTimeFormatter formatter) {
        LocalDateTimeSplit localDateTimeSplit = new LocalDateTimeSplit(start, end);
        localDateTimeSplit.formatter = formatter;
        return localDateTimeSplit;
    }

    /**
     *
     * @param start
     * @return
     */
    public static LocalDateTimeSplit fromFormatted(int start) {
        return new LocalDateTimeSplit(start, END_OF_LINE);
    }

    /**
     *
     * @param start
     * @param formatter
     * @return
     */
    public static LocalDateTimeSplit fromFormatted(int start, DateTimeFormatter formatter) {
        LocalDateTimeSplit localDateTimeSplit = new LocalDateTimeSplit(start, END_OF_LINE);
        localDateTimeSplit.formatter = formatter;
        return localDateTimeSplit;
    }

    /**
     *
     * @param source the String source
     * @return
     * @throws SplitterException
     */
    @Override
    public LocalDateTime split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        return (formatter == null) ? LocalDateTime.parse(result) : LocalDateTime.parse(result, formatter);
    }
}
