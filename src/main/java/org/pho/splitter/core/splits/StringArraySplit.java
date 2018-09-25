package org.pho.splitter.core.splits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Converts a StringSplit sequence into a <strong>List</strong> of <strong>String</strong>.
 */
public class StringArraySplit extends AbstractSplitter<List<String>> {

    private List<StringSplit> splitters;

    /**
     * Creates a StringArraySplit object with no splits inside.
     */
    public StringArraySplit() {
        super(0,0);
        splitters = new ArrayList<>();
    }

    /**
     * Add a new String Split.
     *
     * @param stringSplit the String Splitter to be added.
     */
    public void addSplit(StringSplit stringSplit) {
        splitters.add(stringSplit);
    }

    /**
     * Retrive all added String Splitters.
     *
     * @return all added String Spllitters
     */
    public List<StringSplit> getSplitters() {
        return splitters;
    }

    /**
     * Split the String according to the added String Splitters.
     *
     * @param source the source String
     * @return A list of Strings splitted according to added String Splitters
     */
    public List<String> split(String source) {
        return splitters
            .stream()
            .map(s -> s.split(source))
            .collect(Collectors.toList());
    }

}
