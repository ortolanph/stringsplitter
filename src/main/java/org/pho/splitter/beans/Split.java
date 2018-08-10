package org.pho.splitter.beans;

import java.util.Objects;

public class Split {

    private static final int END_OF_LINE = 0;

    private int start;

    private int end;

    private Split(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Split newSplit(int start, int end) {
        return new Split(start, end);
    }

    public static Split newSplit(int start) {
        return new Split(start, END_OF_LINE);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean hasEnd() {
        return end != END_OF_LINE;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Split split = (Split) o;
        return start == split.start &&
            end == split.end;
    }

    @Override public int hashCode() {
        return Objects.hash(start, end);
    }
}
