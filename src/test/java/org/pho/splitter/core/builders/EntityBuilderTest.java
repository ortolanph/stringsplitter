package org.pho.splitter.core.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.builders.entity.Project;
import org.pho.splitter.core.splits.IntegerSplit;
import org.pho.splitter.core.splits.StringSplit;
import org.pho.splitter.core.splits.features.WordCase;

import static org.junit.jupiter.api.Assertions.*;

class EntityBuilderTest {

    private EntityBuilder entityBuilder;

    private String clazzName;

    private String DATA = "    1STRING SPLITTER     TRUE æ 4 901100188201101JAVA      SPLITTERS PRIMITIVESOBJECTS   MAVEN  2  0  0";

    @BeforeEach
    public void setUp() {
        entityBuilder = EntityBuilder.newEntityBuilder();
        clazzName = Project.class.getCanonicalName();
    }

    @Test
    public void creationTest() {
        assertNotNull(entityBuilder);
    }

    @Test
    public void forClassString() {
        Object project = entityBuilder
            .forClass(clazzName)
            .buildEntity(DATA);

        assertAll(
                () -> assertTrue(project instanceof Object),
                () -> assertTrue(project instanceof Project)
        );
    }

    @Test
    public void forClassClass() {
        Object project = entityBuilder
            .forClass(Project.class)
            .buildEntity(DATA);

        assertAll(
                () -> assertTrue(project instanceof Object),
                () -> assertTrue(project instanceof Project)
        );
    }

    @Test
    public void stringSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .stringField("name", StringSplit.newSplit(5, 25, WordCase.LOWER_CASE, true))
            .buildEntity(DATA);

        String expected = "string splitter";

        assertAll(
                () -> assertTrue(project instanceof Project),
                () -> assertEquals(expected, project.getName())
        );
    }

    @Test
    public void intSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .intField("id", IntegerSplit.newIntegerSplit(0, 5))
            .intField("businessCode", IntegerSplit.newIntegerSplit(36, 41))
            .buildEntity(DATA);

        int idExpected = 1;
        int businessCodeExpected = 11001;

        assertAll(
                () -> assertTrue(project instanceof Project),
                () -> assertEquals(idExpected, project.getId()),
                () -> assertEquals(businessCodeExpected, project.getBusinessCode()));
    }

}
