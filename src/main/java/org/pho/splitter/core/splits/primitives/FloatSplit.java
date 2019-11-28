package org.pho.splitter.core.splits.primitives;

import org.pho.splitter.core.exception.SplitterException;
import org.pho.splitter.core.splits.AbstractSplitter;

public class FloatSplit extends AbstractSplitter<Float> {

    private FloatSplit(int start, int end) {
        super(start, end);
    }

    public static FloatSplit newFloatSplit(int start, int end) {
        return new FloatSplit(start, end);
    }


    @Override
    public Float split(String source) throws SplitterException {
        String result = ((hasEnd()) ? source.substring(getStart(), getEnd()) : source.substring(getStart())).trim();
        result = removeSpecialCharacters(result);

        try {
            return Float.valueOf(result.trim());
        } catch (Exception e) {
            throw new SplitterException(e.getMessage(), e);
        }
    }
}
