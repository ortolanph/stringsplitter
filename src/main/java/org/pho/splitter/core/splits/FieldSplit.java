package org.pho.splitter.core.splits;

import org.pho.splitter.core.exception.SplitterException;

public class FieldSplit<R> {

    private final String fieldName;

    private final AbstractSplitter<R> splitter;

    private FieldSplit(String fieldName, AbstractSplitter<R> splitter) {
        this.fieldName = fieldName;
        this.splitter = splitter;
    }

    public static <R> FieldSplit<R> newFieldSplit(String name, AbstractSplitter<R> splitter) {
        return new FieldSplit<>(name, splitter);
    }

    public R split(String source) throws SplitterException {
        return splitter.split(source);
    }

    public String getFieldName() {
        return fieldName;
    }
}
