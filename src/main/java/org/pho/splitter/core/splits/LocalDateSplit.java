package org.pho.splitter.core.splits;

import jdk.vm.ci.meta.Local;
import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSplit extends AbstractSplitter<LocalDate> {

    private DateTimeFormatter format;

    /**
     * Creates a new LocalDateSplitter.
     *
     * @param start             where the split starts
     * @param end               where the split ends
     * @param specialCharacters the special character to be removed
     */
    private LocalDateSplit(int start, int end, String... specialCharacters) {
        super(start, end, specialCharacters);
    }

    public static LocalDateSplit newLocalDateSplit(int start, int end) {
        return new LocalDateSplit(start, end, null);
    }

    public static LocalDateSplit newLocalDateSplit(int start, int end, DateTimeFormatter formatter) {
        return null;
    }

    @Override
    public LocalDate split(String source) throws SplitterException {
        return (format == null) ?
                LocalDate.parse(source.substring(getStart(), getEnd())) :
                LocalDate.parse(source.substring(getStart(), getEnd()), format);
    }
}
