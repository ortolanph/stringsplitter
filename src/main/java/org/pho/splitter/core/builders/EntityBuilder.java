package org.pho.splitter.core.builders;

import org.pho.splitter.core.splits.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.invoke.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 */
public final class EntityBuilder {

    private List<FieldSplit> splits;

    private Object entity;

    private String clazz;

    private EntityBuilder() {
        splits = new ArrayList<>();
    }

    /**
     *
     */
    public static EntityBuilder newEntityBuilder() {
        return new EntityBuilder();
    }

    /**
     *
     * @param clazz
     * @return
     */
    public EntityBuilder forClass(String clazz) {
        this.clazz = clazz;
        return this;
    }

    /**
     *
     * @param clazz
     * @return
     */
    public EntityBuilder forClass(Class clazz) {
        this.clazz = clazz.getCanonicalName();
        return this;
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder stringField(String name, StringSplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder stringArrayField(String name, StringArraySplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder booleanField(String name, BooleanSplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder byteField(String name, ByteSplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder shortField(String name, ShortSplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder characterField(String name, CharacterSplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder intField(String name, IntegerSplit split) {
        return addSplitter(name, split);
    }

    /**
     *
     * @param name
     * @param split
     * @return
     */
    public EntityBuilder longField(String name, LongSplit split) {
        return addSplitter(name, split);
    }
    
    public EntityBuilder fields(FieldSplit... splits) {
        this.splits.addAll(Arrays.asList(splits));
        return this;
    }

    // Please, refactor me!
    /**
     *
     * @param source
     * @return
     */
    public Object buildEntity(String source) {
        try {
            final MethodHandles.Lookup lookup = MethodHandles.lookup();

            Object object = Class.forName(clazz).newInstance();

            for(FieldSplit split : splits) {
                PropertyDescriptor fieldDescriptor = getDescriptor(split.getFieldName());

                final BiConsumer propSetter =
                    createSetter(
                        lookup,
                        lookup.unreflect(fieldDescriptor.getWriteMethod()));

                propSetter.accept(object, split.split(source));
            }

            return object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    private EntityBuilder addSplitter(String name, AbstractSplitter<?> split) {
        splits.add(FieldSplit.newFieldSplit(name, split));
        return this;
    }

    // Please, refactor me!
    private static BiConsumer createSetter(final MethodHandles.Lookup lookup,
        final MethodHandle setter) throws Exception {
        final CallSite site = LambdaMetafactory.metafactory(lookup,
            "accept",
            MethodType.methodType(BiConsumer.class),
            MethodType.methodType(void.class, Object.class, Object.class), //signature of method BiConsumer.accept after type erasure
            setter,
            setter.type()); //actual signature of setter
        try {
            return (BiConsumer) site.getTarget().invokeExact();
        } catch (final Exception e) {
            throw e;
        } catch (final Throwable e) {
            throw new Error(e);
        }
    }

    // Please, refactor me!
    private PropertyDescriptor getDescriptor(String fieldName) {
        final BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(Class.forName(clazz));

            final Function<String, PropertyDescriptor> property = name -> Stream.of(beanInfo.getPropertyDescriptors())
                .filter(p -> name.equals(p.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Not found: " + name));

            return property.apply(fieldName);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    
}