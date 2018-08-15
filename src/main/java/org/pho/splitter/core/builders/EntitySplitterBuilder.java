package org.pho.splitter.core.builders;

import org.pho.splitter.core.splitters.*;

public class EntitySplitterBuilder<T> {

    private static final EntitySplitterBuilder INSTANCE = new EntitySplitterBuilder();

    private static EntitySplitter splitter;

    private EntitySplitterBuilder() { }

    public static EntitySplitterBuilder newSplitter() {
        splitter = new EntitySplitter();
        return INSTANCE;
    }

    public EntitySplitterBuilder forClass(String clazz) {
        return this;
    }

    public EntitySplitterBuilder forClass(Class<T> clazz) {
        return this;
    }

    public EntitySplitterBuilder stringField(String name, StringSplitter splitter) {
        return this;
    }

    public EntitySplitterBuilder booleanField(String name, BooleanSplitter splitter) {
        return this;
    }

    public EntitySplitterBuilder byteField(String name, ByteSplitter split) {
        return this;
    }

    public EntitySplitterBuilder charField(String name, CharacterSplitter split) {
        return this;
    }

    public EntitySplitterBuilder intField(String name, IntegerSplitter split)  {
        return this;
    }

    public EntitySplitterBuilder longField(String name, LongSplitter split) {
        return this;
    }

    public T build() {
        return null;
    }

}
