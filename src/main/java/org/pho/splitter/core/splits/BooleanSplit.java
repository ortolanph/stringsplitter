package org.pho.splitter.core.splits;

import java.util.function.Function;

public class BooleanSplit extends AbstractSplitter<Boolean> {

    private Function<String, Boolean> conversionFunction;

    private BooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        this.conversionFunction = conversionFunction;
    }

    public BooleanSplit newBooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, end, conversionFunction);
    }

    public BooleanSplit newBooleanSplit(int start, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, END_OF_LINE, conversionFunction);
    }

    @Override public Boolean split(String source) {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        return conversionFunction.apply(result);
    }

}
