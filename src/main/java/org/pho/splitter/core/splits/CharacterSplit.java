package org.pho.splitter.core.splits;

/**
 *
 */
public class CharacterSplit extends AbstractSplitter<Character> {

    private CharacterSplit(int start) {
        super(start, start + 1);
    }

    /**
     *
     * @param start
     * @return
     */
    public static CharacterSplit newCharacterSplit(int start) {
        return new CharacterSplit(start);
    }

    /**
     *
     * @param source
     * @return
     */
    @Override public Character split(String source) {
        String result = source.substring(getStart(), getEnd());
        return result.toCharArray()[0];
    }
}
