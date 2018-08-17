package org.pho.splitter.core.builders;

import org.pho.splitter.core.splits.*;

public class EntitySplitterBuilder<T> {

    private static final EntitySplitterBuilder INSTANCE = new EntitySplitterBuilder();

//    private static EntitySplitter splitter;

    private EntitySplitterBuilder() {
    }

    public static EntitySplitterBuilder newSplitter() {
//        splitter = new EntitySplitter();
        return INSTANCE;
    }

    public EntitySplitterBuilder forClass(String clazz) {
        return this;
    }

    public EntitySplitterBuilder forClass(Class<T> clazz) {
        return this;
    }

    public EntitySplitterBuilder stringField(String name, StringSplit splitter) {
        return this;
    }

    public EntitySplitterBuilder booleanField(String name, BooleanSplit splitter) {
        return this;
    }

    public EntitySplitterBuilder byteField(String name, ByteSplit split) {
        return this;
    }

    public EntitySplitterBuilder charField(String name, CharacterSplit split) {
        return this;
    }

    public EntitySplitterBuilder intField(String name, IntegerSplit split) {
        return this;
    }

    public EntitySplitterBuilder longField(String name, LongSplit split) {
        return this;
    }

    public T build() {
        return null;
    }

}
