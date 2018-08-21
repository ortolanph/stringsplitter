package org.pho.splitter.core.function;

import org.pho.splitter.core.exception.SplitterException;

@FunctionalInterface
public interface SplitFunction<R> {

    R split(String source) throws SplitterException;

}
