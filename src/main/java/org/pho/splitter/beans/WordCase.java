package org.pho.splitter.beans;

import java.util.function.Function;

public enum WordCase implements Function<String, String> {

    UPPER_CASE(s -> s.toUpperCase()),
    LOWER_CASE(s -> s.toLowerCase()),
    NO_CASE(s -> s);

    private Function<String, String> trimFunction;

    WordCase(Function<String, String> trimFunction) {
        this.trimFunction = trimFunction;
    }

    @Override public String apply(String s) {
        return trimFunction.apply(s);
    }
}
