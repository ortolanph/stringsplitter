package org.pho.splitter.core.splits.primitives;

import org.pho.splitter.core.splits.AbstractSplitter;

import java.util.function.Function;

/**
 * Converts a String split into a <strong>Boolean</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public class BooleanSplit extends AbstractSplitter<Boolean> {

    private Function<String, Boolean> conversionFunction;

    private BooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        super(start, end);
        this.conversionFunction = conversionFunction;
    }

    /**
     * Adds a String conversion into a Boolean.
     *
     * @param start              where the split starts
     * @param end                where the split ends
     * @param conversionFunction the conversion function. It can convert a <code>0</code> to <code>false</code> and
     *                           <code>1</code> to <code>true</code>
     * @return an instance of BoooleanSplit
     */
    public static BooleanSplit newBooleanSplit(int start, int end, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, end, conversionFunction);
    }

    /**
     * Adds a String conversion into a Boolean.
     *
     * @param start              where the split starts
     * @param conversionFunction the conversion function. It can convert a <code>0</code> to <code>false</code> and
     *                           <code>1</code> to <code>true</code>
     * @return an instance of BoooleanSplit
     */
    public static BooleanSplit newBooleanSplit(int start, Function<String, Boolean> conversionFunction) {
        return new BooleanSplit(start, END_OF_LINE, conversionFunction);
    }

    /**
     * Splits the String source into a boolean.
     *
     * @param source the String source
     * @return a Boolean converted from a String
     */
    @Override
    public Boolean split(String source) {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        return conversionFunction.apply(result);
    }

}
