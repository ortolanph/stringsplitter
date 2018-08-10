package org.pho.splitter.core;

import org.pho.splitter.beans.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    private List<Split> splitters;

    public StringSplitter() {
        splitters = new ArrayList<>();
    }

    public void addSplit(Split split) {
        splitters.add(split);
    }

    public List<Split> getSplitters() {
        return splitters;
    }

    public List<String> split(String source) {
        return splitters
            .stream()
            .map(s -> s.split(source))
            .collect(Collectors.toList());
    }

}
