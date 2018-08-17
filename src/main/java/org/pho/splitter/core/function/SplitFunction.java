package org.pho.splitter.core.function;

@FunctionalInterface
public interface SplitFunction<R> {

    R split(String source);

}
