package org.pho.splitter.core.splits;

import org.pho.splitter.core.builders.EntityBuilder;
import org.pho.splitter.core.exception.SplitterException;

public class EntitySplit extends AbstractSplitter<Object> {

    private EntityBuilder entityBuilder;

    public EntitySplit(EntityBuilder entityBuilder) {
        super(0, 0, null);
        this.entityBuilder = entityBuilder;
    }

    @Override
    public Object split(String source) throws SplitterException {
        return entityBuilder.buildEntity(source);
    }
}
