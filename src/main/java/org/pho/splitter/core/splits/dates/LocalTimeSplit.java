package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Converts a String split into a <strong>LocalDateTime</strong> object.
 *
 * @author Paulo Henrique Ortolan
 */
public class LocalTimeSplit extends AbstractSplitter<LocalTime> {

    private DateTimeFormatter formatter;

    private LocalTimeSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds
     * @param start
     * @param end
     * @return
     */
    public static LocalTimeSplit newLocalTimeSplit(int start, int end) {
        return new LocalTimeSplit(start, end);
    }

    /**
     *
     * @param start
     * @return
     */
    public static LocalTimeSplit newLocalTimeSplit(int start) {
        return new LocalTimeSplit(start, END_OF_LINE);
    }

    /**
     *
     * @param start
     * @param end
     * @param formatter
     * @return
     */
    public static LocalTimeSplit fromFormatted(int start, int end, DateTimeFormatter formatter) {
        LocalTimeSplit timeSplit = new LocalTimeSplit(start, end);
        timeSplit.formatter = formatter;
        return timeSplit;
    }

    /**
     *
     * @param start
     * @param formatter
     * @return
     */
    public static LocalTimeSplit fromFormatted(int start, DateTimeFormatter formatter) {
        LocalTimeSplit timeSplit = new LocalTimeSplit(start, END_OF_LINE);
        timeSplit.formatter = formatter;
        return timeSplit;
    }

    /**
     *
     * @param source the String source
     * @return
     * @throws SplitterException
     */
    @Override
    public LocalTime split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        return (formatter == null) ? LocalTime.parse(result) : LocalTime.parse(result, formatter);
    }
}
