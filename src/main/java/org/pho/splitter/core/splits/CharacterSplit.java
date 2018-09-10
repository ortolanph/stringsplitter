package org.pho.splitter.core.splits;

public class CharacterSplit extends AbstractSplitter<Character> {

    private CharacterSplit(int start) {
        super(start, start + 1);
    }

    public static CharacterSplit newCharacterSplit(int start) {
        return new CharacterSplit(start);
    }

    @Override public Character split(String source) {
        String result = source.substring(getStart(), getEnd());
        return result.toCharArray()[0];
    }
}
