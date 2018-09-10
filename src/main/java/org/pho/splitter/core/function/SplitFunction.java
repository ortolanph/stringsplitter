package org.pho.splitter.core.function;

import org.pho.splitter.core.exception.SplitterException;

/**
 *
 * @param <R>
 */
@FunctionalInterface
public interface SplitFunction<R> {

    /**
     *
     * @param source
     * @return
     * @throws SplitterException
     */
    R split(String source) throws SplitterException;

}
