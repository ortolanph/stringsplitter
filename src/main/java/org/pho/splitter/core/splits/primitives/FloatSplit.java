package org.pho.splitter.core.splits.primitives;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.text.DecimalFormat;

/**
 * Converts a String split into a <strong>Float</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public class FloatSplit extends AbstractSplitter<Float> {

    private DecimalFormat format;

    private FloatSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into a Float.
     *
     * @param start start where the split starts
     * @param end   end end where the split ends
     * @return an instance of FloatSplit
     */
    public static FloatSplit newFloatSplit(int start, int end) {
        return new FloatSplit(start, end);
    }

    /**
     * Adds a String conversion into a Float.
     *
     * @param start start where the split starts
     * @return an instance of FloatSplit
     */
    public static FloatSplit newFloatSplit(int start) {
        return new FloatSplit(start, END_OF_LINE);
    }

    /**
     * Adds a String conversion into a Float.
     *
     * @param start  start where the split starts
     * @param end    end end where the split ends
     * @param format an instance of ${java.lang.DecimalFormat}
     * @return an instance of FloatSplit
     */
    public static FloatSplit newFloatSplit(int start, int end, DecimalFormat format) {
        FloatSplit floatSplit = new FloatSplit(start, end);
        floatSplit.format = format;
        return floatSplit;
    }

    /**
     * Adds a String conversion into a Float.
     *
     * @param start  start where the split start
     * @param format an instance of ${java.lang.DecimalFormat}
     * @return an instance of FloatSplit
     */
    public static FloatSplit newFloatSplit(int start, DecimalFormat format) {
        return newFloatSplit(start, END_OF_LINE, format);
    }

    /**
     * Splits the String source into a float.
     *
     * @param source the String source
     * @return a Float converted from a String
     * @throws SplitterException when the conversion goes wrong
     */
    @Override
    public Float split(String source) throws SplitterException {
        String result = simpleSplit(source);

        try {
            return (format == null) ? Float.parseFloat(result.trim()) : format.parse(result.trim()).floatValue();
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
