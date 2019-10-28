package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

import java.time.LocalDate;

public class LocalDateSplit extends AbstractSplitter<LocalDate> {

    /**
     * Creates a new AbstractSplitter.
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

    @Override
    public LocalDate split(String source) throws SplitterException {
        return null;
    }
}
