package org.pho.splitter.core.splits;

/**
 * Converts a String split into a <strong>Character</strong>.
 *
 * @author Paulo Henrique Ortolan
 */
public class CharacterSplit extends AbstractSplitter<Character> {

    private CharacterSplit(int start) {
        super(start, start + 1);
    }

    /**
     * Adds a String conversion into a Character.
     *
     * @param start where the split starts
     * @return an instance of CharacterSplit
     */
    public static CharacterSplit newCharacterSplit(int start) {
        return new CharacterSplit(start);
    }

    /**
     * Splits the String source into a character.
     *
     * @param source the String source
     * @return a Character converted from a String
     */
    @Override public Character split(String source) {
        String result = source.substring(getStart(), getEnd());
        return result.toCharArray()[0];
    }
}
