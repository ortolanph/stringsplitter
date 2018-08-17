package org.pho.splitter.core.splits;

import org.pho.splitter.core.function.SplitFunction;

public abstract class AbstractSplitter<T> implements SplitFunction<T> {

    protected static final int END_OF_LINE = 0;

    private int start;

    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    protected boolean hasEnd() {
        return end != END_OF_LINE;
    }
}
