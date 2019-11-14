package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSplit extends AbstractSplitter<LocalDateTime> {

    private DateTimeFormatter formatter;

    private LocalDateTimeSplit(int start, int end) {
        super(start, end);
    }

    public static LocalDateTimeSplit newLocalDateTimeSplit(int start, int end) {
        return new LocalDateTimeSplit(start, end);
    }

    public static LocalDateTimeSplit newLocalDateTimeSplit(int start, int end, DateTimeFormatter formatter) {
        LocalDateTimeSplit localDateTimeSplit = new LocalDateTimeSplit(start, end);
        localDateTimeSplit.formatter = formatter;
        return localDateTimeSplit;
    }

    public static LocalDateTimeSplit newLocalDateTimeSplit(int start) {
        return new LocalDateTimeSplit(start, END_OF_LINE);
    }

    public static LocalDateTimeSplit newLocalDateTimeSplit(int start, DateTimeFormatter formatter) {
        LocalDateTimeSplit localDateTimeSplit = new LocalDateTimeSplit(start, END_OF_LINE);
        localDateTimeSplit.formatter = formatter;
        return localDateTimeSplit;
    }

    @Override
    public LocalDateTime split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        return (formatter == null) ? LocalDateTime.parse(result) : LocalDateTime.parse(result, formatter);
    }
}
