package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

public class ByteSplit extends AbstractSplitter<Byte> {

    private ByteSplit(int start, int end) {
        super(start, end);
    }

    public static ByteSplit newByteSplit(int start, int end) {
        return new ByteSplit(start, end);
    }

    public static ByteSplit newByteSplit(int start) {
        return new ByteSplit(start, END_OF_LINE);
    }

    @Override public Byte split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();

        try {
            return Byte.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
