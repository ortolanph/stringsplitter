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
public class LocalDateSplit extends AbstractSplitter<LocalDate> {

    private DateTimeFormatter formatter;

    private LocalDateSplit(int start, int end) {
        super(start, end);
    }

    /**
     * @param start
     * @param end
     * @return
     */
    public static LocalDateSplit newLocalDateSplit(int start, int end) {
        return new LocalDateSplit(start, end);
    }

    /**
     *
     * @param start
     * @return
     */
    public static LocalDateSplit newLocalDateSplit(int start) {
        return new LocalDateSplit(start, END_OF_LINE);
    }

    /**
     *
     * @param start
     * @param end
     * @param formatter
     * @return
     */
    public static LocalDateSplit fromFormatted(int start, int end, DateTimeFormatter formatter) {
        LocalDateSplit localDateSplit = newLocalDateSplit(start, end);
        localDateSplit.formatter = formatter;
        return localDateSplit;
    }

    /**
     *
     * @param start
     * @param formatter
     * @return
     */
    public static LocalDateSplit fromFormatted(int start, DateTimeFormatter formatter) {
        return fromFormatted(start, END_OF_LINE, formatter);
    }

    /**
     *
     * @param source the String source
     * @return
     * @throws SplitterException
     */
    @Override
    public LocalDate split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        return (formatter == null) ? LocalDate.parse(result) : LocalDate.parse(result, formatter);
    }
}
