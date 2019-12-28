package org.pho.splitter.core.splits.primitives;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

import java.text.DecimalFormat;

/**
 * Converts a String split into a <strong>Double</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public class DoubleSplit extends AbstractSplitter<Double> {

    private DecimalFormat format;

    private DoubleSplit(int start, int end) {
        super(start, end);
    }

    /**
     * Adds a String conversion into a Double.
     *
     * @param start start where the split starts
     * @param end   end end where the split ends
     * @return an instance of DoubleSplit
     */
    public static DoubleSplit newDoubleSplit(int start, int end) {
        return new DoubleSplit(start, end);
    }

    /**
     * Adds a String conversion into a Double.
     *
     * @param start start where the split starts
     * @return an instance of DoubleSplit
     */
    public static DoubleSplit newDoubleSplit(int start) {
        return new DoubleSplit(start, END_OF_LINE);
    }

    /**
     * Adds a String conversion into a Double.
     *
     * @param start  start where the split starts
     * @param end    end end where the split ends
     * @param format an instance of ${java.lang.DecimalFormat}
     * @return an instance of DoubleSplit
     */
    public static DoubleSplit newDoubleSplit(int start, int end, DecimalFormat format) {
        DoubleSplit floatSplit = new DoubleSplit(start, end);
        floatSplit.format = format;
        return floatSplit;
    }

    /**
     * Adds a String conversion into a Double.
     *
     * @param start  start where the split start
     * @param format an instance of ${java.lang.DecimalFormat}
     * @return an instance of DoubleSplit
     */
    public static DoubleSplit newDoubleSplit(int start, DecimalFormat format) {
        return newDoubleSplit(start, END_OF_LINE, format);
    }

    /**
     * Splits the String source into a double.
     *
     * @param source the String source
     * @return a Double converted from a String
     * @throws SplitterException when the conversion goes wrong
     */
    @Override
    public Double split(String source) throws SplitterException {
        String result = simpleSplit(source);

        try {
            return (format == null) ? Double.parseDouble(result.trim()) : format.parse(result.trim()).floatValue();
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
