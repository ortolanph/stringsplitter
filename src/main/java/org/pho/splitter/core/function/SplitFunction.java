package org.pho.splitter.core.function;

import org.pho.splitter.core.exception.SplitterException;

/**
 * The main split function.
 *
 * @param <R> the type to be returned.
 * @author Paulo Henrique Ortolan
 */
@FunctionalInterface
public interface SplitFunction<R> {

    /**
     *  Split the String source according to the Splitter construct.
     *
     * @param source the String source
     * @return the value of type R splitted from source
     * @throws SplitterException if something goes wrong
     */
    R split(String source) throws SplitterException;

}
