package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

public class ShortSplit extends AbstractSplitter<Short> {

    private String format;

    private ShortSplit(int start, int end) {
        setStart(start);
        setEnd(end);
    }

    private ShortSplit(int start, int end, String format) {
        this(start, end);
        this.format = format;
    }

    public static ShortSplit newShortSplit(int start, int end) {
        return new ShortSplit(start, end);
    }

    public static ShortSplit newShortSplit(int start) {
        return new ShortSplit(start, END_OF_LINE);
    }

    public static ShortSplit newShortSplit(int start, int end, String format) {
        return new ShortSplit(start, end, format);
    }

    public static ShortSplit newShortSplit(int start, String format) {
        return new ShortSplit(start, END_OF_LINE, format);
    }

    @Override public Short split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();

        try {
            return Short.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
