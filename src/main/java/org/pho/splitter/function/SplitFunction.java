package org.pho.splitter.function;

@FunctionalInterface
public interface SplitFunction<R> {

    R split(String source);

}
