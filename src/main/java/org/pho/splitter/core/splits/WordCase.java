package org.pho.splitter.core.splits;

import java.util.function.Function;

/**
 * Word case enum to convert String cases.
 */
public enum WordCase implements Function<String, String> {

    /**
     * Enum item to convert to upper case.
     */
    UPPER_CASE(s -> s.toUpperCase()),
    /**
     * Enum item to convert to lower case.
     */
    LOWER_CASE(s -> s.toLowerCase()),
    /**
     * Don't convert.
     */
    NO_CASE(s -> s);

    private Function<String, String> caseFunction;

    WordCase(Function<String, String> caseFunction) {
        this.caseFunction = caseFunction;
    }

    /**
     * Apply the convert function.
     *
     * @param source the String source
     * @return the String source converted
     */
    @Override public String apply(String source) {
        return caseFunction.apply(source);
    }
}
