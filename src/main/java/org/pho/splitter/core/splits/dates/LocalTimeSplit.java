package org.pho.splitter.core.splits.dates;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeSplit extends AbstractSplitter<LocalTime> {

    private DateTimeFormatter formatter;

    private LocalTimeSplit(int start, int end) {
        super(start, end);
    }

    public static LocalTimeSplit newSplit(int start, int end) {
        return new LocalTimeSplit(start, end);
    }

    public static LocalTimeSplit newLocalTimeSplit(int start) {
        return new LocalTimeSplit(start, END_OF_LINE);
    }

    public static LocalTimeSplit newLocalTimeSplit(int start, int end, DateTimeFormatter formatter) {
        LocalTimeSplit timeSplit = new LocalTimeSplit(start, end);
        timeSplit.formatter = formatter;
        return timeSplit;
    }

    public static LocalTimeSplit newLocalTimeSplit(int start, DateTimeFormatter formatter) {
        LocalTimeSplit timeSplit = new LocalTimeSplit(start, END_OF_LINE);
        timeSplit.formatter = formatter;
        return timeSplit;
    }

    @Override
    public LocalTime split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        return (formatter == null) ? LocalTime.parse(result) : LocalTime.parse(result, formatter);
    }
}
