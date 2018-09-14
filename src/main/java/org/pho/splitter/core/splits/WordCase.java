package org.pho.splitter.core.splits;

import java.util.function.Function;

/**
 *
 */
public enum WordCase implements Function<String, String> {

    /**
     *
     */
    UPPER_CASE(s -> s.toUpperCase()),
    /**
     *
     */
    LOWER_CASE(s -> s.toLowerCase()),
    /**
     *
     */
    NO_CASE(s -> s);

    private Function<String, String> caseFunction;

    WordCase(Function<String, String> caseFunction) {
        this.caseFunction = caseFunction;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override public String apply(String s) {
        return caseFunction.apply(s);
    }
}
