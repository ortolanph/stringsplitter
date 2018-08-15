package org.pho.splitter.beans;

import org.pho.splitter.function.SplitFunction;

import java.util.function.Function;

public class BooleanSplit implements SplitFunction<Boolean> {

    private int start;

    private int end;

    private Function<String, Boolean> conversionFunction;

    private static final int END_OF_LINE = 0;

    private BooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        this.start = start;
        this.end = end;
        this.conversionFunction = conversionFunction;
    }

    public BooleanSplit newBooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, end, conversionFunction);
    }

    public BooleanSplit newBooleanSplit(int start, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, END_OF_LINE, conversionFunction);
    }

    @Override public Boolean split(String source) {
        String result = ((hasEnd())? source.substring(start, end) : source.substring(start)).trim();
        return conversionFunction.apply(result);
    }

    private boolean hasEnd() {
        return end != END_OF_LINE;
    }
}
