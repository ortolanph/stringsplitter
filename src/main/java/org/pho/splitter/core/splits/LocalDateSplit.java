package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class LocalDateSplit extends AbstractSplitter<LocalDate> {

    private DateTimeFormatter formatter;

    private LocalDateSplit(int start) {
        super(start, END_OF_LINE);
    }

    private LocalDateSplit(int start, int end) {
        super(start, end);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public static LocalDateSplit newLocalDateSplit(int start, int end) {
        return new LocalDateSplit(start, end);
    }

    public static LocalDateSplit newLocalDateSplit(int start) {
        return new LocalDateSplit(start);
    }

    public static LocalDateSplit newLocalDateSplit(int start, int end, DateTimeFormatter formatter) {
        LocalDateSplit localDateSplit = newLocalDateSplit(start, end);
        localDateSplit.formatter = formatter;
        return localDateSplit;
    }

    public static LocalDateSplit newLocalDateSplit(int start, DateTimeFormatter formatter) {
        return newLocalDateSplit(start, END_OF_LINE, formatter);
    }

    @Override
    public LocalDate split(String source) throws SplitterException {
        return (formatter == null) ?
                LocalDate.parse(source.substring(getStart(), getEnd())) :
                LocalDate.parse(source.substring(getStart(), getEnd()), formatter);
    }
}
