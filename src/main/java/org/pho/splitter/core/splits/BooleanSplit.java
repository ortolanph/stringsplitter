package org.pho.splitter.core.splits;

import java.util.function.Function;

/**
 *
 */
public class BooleanSplit extends AbstractSplitter<Boolean> {

    private Function<String, Boolean> conversionFunction;

    private BooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        super(start, end);
        this.conversionFunction = conversionFunction;
    }

    /**
     *
     * @param start
     * @param end
     * @param conversionFunction
     * @return
     */
    public static BooleanSplit newBooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, end, conversionFunction);
    }

    /**
     *
     * @param start
     * @param conversionFunction
     * @return
     */
    public static BooleanSplit newBooleanSplit(int start, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, END_OF_LINE, conversionFunction);
    }

    /**
     *
     * @param source
     * @return
     */
    @Override public Boolean split(String source)  {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        return conversionFunction.apply(result);
    }

}
