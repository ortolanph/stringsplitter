package org.pho.splitter.core.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pho.splitter.core.splits.*;
import org.pho.splitter.core.splits.features.WordCase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class EntityBuilderTest {

    private EntityBuilder entityBuilder;

    private String clazzName;

    private Project expectedProject;

    private static final Function<String, Boolean> TRUE_FALSE_FUNCTION =
        source -> (source.trim().toLowerCase().equals("true"))? Boolean.TRUE : Boolean.FALSE;

    private String DATA = "    1STRING SPLITTER     TRUE æ 4 901100188201101JAVA      SPLITTERS PRIMITIVESOBJECTS   MAVEN  2  0  0";

    @BeforeEach
    public void setUp() {
        entityBuilder = EntityBuilder.newEntityBuilder();
        clazzName = Project.class.getCanonicalName();
        expectedProject = createTestProject();
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

        String expected = expectedProject.getName();

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

        int idExpected = expectedProject.getId();
        int businessCodeExpected = expectedProject.getBusinessCode();

        assertAll(
                () -> assertTrue(project instanceof Project),
                () -> assertEquals(idExpected, project.getId()),
                () -> assertEquals(businessCodeExpected, project.getBusinessCode()));
    }

    @Test
    public void booleanSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .booleanField("active", BooleanSplit.newBooleanSplit(25, 30, TRUE_FALSE_FUNCTION))
            .buildEntity(DATA);

        boolean activeExpected = expectedProject.isActive();

        assertAll(
            () -> assertTrue(project instanceof Project),
            () -> assertEquals(activeExpected, project.isActive()));
    }

    @Test
    public void characterSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .characterField("symbol", CharacterSplit.newCharacterSplit(30))
            .buildEntity(DATA);

        char symbolExpected = expectedProject.getSymbol();

        assertAll(
            () -> assertTrue(project instanceof Project),
            () -> assertEquals(symbolExpected, project.getSymbol()));
    }

    @Test
    public void byteSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .byteField("teamSize", ByteSplit.newByteSplit(31, 33))
            .buildEntity(DATA);

        byte teamSizeExpected = expectedProject.getTeamSize();

        assertAll(
            () -> assertTrue(project instanceof Project),
            () -> assertEquals(teamSizeExpected, project.getTeamSize()));
    }


    @Test
    public void shortSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .shortField("lunchTime", ShortSplit.newShortSplit(33, 36))
            .buildEntity(DATA);

        short lunchTimeExpected = expectedProject.getLunchTime();

        assertAll(
            () -> assertTrue(project instanceof Project),
            () -> assertEquals(lunchTimeExpected, project.getLunchTime()));
    }

    @Test
    public void longSplittingTest() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .longField("responsibleCode", LongSplit.newLongSplit(41, 49))
            .buildEntity(DATA);

        long responsibleCodeExpected = expectedProject.getResponsibleCode();

        assertAll(
            () -> assertTrue(project instanceof Project),
            () -> assertEquals(responsibleCodeExpected, project.getResponsibleCode()));
    }

    @Test
    public void stringArraySplit() {
        Project project = (Project)entityBuilder
            .forClass(Project.class)
            .stringArrayField("keywords", StringArraySplitterBuilder
                .newSplitter()
                .addStringSplit(49, 59, WordCase.LOWER_CASE, true)
                .addStringSplit(59, 69, WordCase.LOWER_CASE, true)
                .addStringSplit(69, 79, WordCase.LOWER_CASE, true)
                .addStringSplit(79, 89, WordCase.LOWER_CASE, true)
                .addStringSplit(89, 96, WordCase.LOWER_CASE, true)
                .build())
            .buildEntity(DATA);

        List<String> expectedKewords = expectedProject.getKeywords();

        assertAll(
            () -> assertTrue(project instanceof Project),
            () -> assertEquals(expectedKewords, project.getKeywords())
        );
    }

    @Test
    public void fields() {
        Project actual = (Project)entityBuilder
            .forClass(Project.class)
            .fields(
                FieldSplit.newFieldSplit("id", IntegerSplit.newIntegerSplit(0, 5)),
                FieldSplit.newFieldSplit("name", StringSplit.newSplit(5, 25, WordCase.LOWER_CASE, true)),
                FieldSplit.newFieldSplit("active", BooleanSplit.newBooleanSplit(25, 30, TRUE_FALSE_FUNCTION)),
                FieldSplit.newFieldSplit("symbol", CharacterSplit.newCharacterSplit(30)),
                FieldSplit.newFieldSplit("teamSize", ByteSplit.newByteSplit(31, 33)),
                FieldSplit.newFieldSplit("lunchTime", ShortSplit.newShortSplit(33, 36)),
                FieldSplit.newFieldSplit("businessCode", IntegerSplit.newIntegerSplit(36, 41)),
                FieldSplit.newFieldSplit("responsibleCode", LongSplit.newLongSplit(41, 49)),
                FieldSplit.newFieldSplit("keywords", StringArraySplitterBuilder
                    .newSplitter()
                    .addStringSplit(49, 59, WordCase.LOWER_CASE, true)
                    .addStringSplit(59, 69, WordCase.LOWER_CASE, true)
                    .addStringSplit(69, 79, WordCase.LOWER_CASE, true)
                    .addStringSplit(79, 89, WordCase.LOWER_CASE, true)
                    .addStringSplit(89, 96, WordCase.LOWER_CASE, true)
                    .build()))
            .buildEntity(DATA);

        Project expected = createTestProject();

        assertAll(
            () -> assertTrue(actual instanceof Project),
            () -> assertEquals(expected.getId(), actual.getId()),
            () -> assertEquals(expected.getName(), actual.getName()),
            () -> assertEquals(expected.isActive(), actual.isActive()),
            () -> assertEquals(expected.getSymbol(), actual.getSymbol()),
            () -> assertEquals(expected.getTeamSize(), actual.getTeamSize()),
            () -> assertEquals(expected.getLunchTime(), actual.getLunchTime()),
            () -> assertEquals(expected.getBusinessCode(), actual.getBusinessCode()),
            () -> assertEquals(expected.getResponsibleCode(), actual.getResponsibleCode()),
            () -> assertEquals(expected.getKeywords(), actual.getKeywords())
        );
    }

    @Test
    public void splits() {
        Project actual = (Project)entityBuilder
            .forClass(Project.class)
            .intField("id",  IntegerSplit.newIntegerSplit(0, 5))
            .stringField("name", StringSplit.newSplit(5, 25, WordCase.LOWER_CASE, true))
            .booleanField("active", BooleanSplit.newBooleanSplit(25, 30, TRUE_FALSE_FUNCTION))
            .characterField("symbol", CharacterSplit.newCharacterSplit(30))
            .byteField("teamSize", ByteSplit.newByteSplit(31, 33))
            .shortField("lunchTime", ShortSplit.newShortSplit(33, 36))
            .intField("businessCode", IntegerSplit.newIntegerSplit(36, 41))
            .longField("responsibleCode", LongSplit.newLongSplit(41, 49))
            .stringArrayField("keywords", StringArraySplitterBuilder
                    .newSplitter()
                    .addStringSplit(49, 59, WordCase.LOWER_CASE, true)
                    .addStringSplit(59, 69, WordCase.LOWER_CASE, true)
                    .addStringSplit(69, 79, WordCase.LOWER_CASE, true)
                    .addStringSplit(79, 89, WordCase.LOWER_CASE, true)
                    .addStringSplit(89, 96, WordCase.LOWER_CASE, true)
                    .build())
            .buildEntity(DATA);

        Project expected = createTestProject();

        assertAll(
            () -> assertTrue(actual instanceof Project),
            () -> assertEquals(expected.getId(), actual.getId()),
            () -> assertEquals(expected.getName(), actual.getName()),
            () -> assertEquals(expected.isActive(), actual.isActive()),
            () -> assertEquals(expected.getSymbol(), actual.getSymbol()),
            () -> assertEquals(expected.getTeamSize(), actual.getTeamSize()),
            () -> assertEquals(expected.getLunchTime(), actual.getLunchTime()),
            () -> assertEquals(expected.getBusinessCode(), actual.getBusinessCode()),
            () -> assertEquals(expected.getResponsibleCode(), actual.getResponsibleCode()),
            () -> assertEquals(expected.getKeywords(), actual.getKeywords())
        );
    }

    @Test
    public void subEntity() {
        Project actual = (Project)entityBuilder
                .forClass(Project.class)
                .intField("id",  IntegerSplit.newIntegerSplit(0, 5))
                .stringField("name", StringSplit.newSplit(5, 25, WordCase.LOWER_CASE, true))
                .booleanField("active", BooleanSplit.newBooleanSplit(25, 30, TRUE_FALSE_FUNCTION))
                .characterField("symbol", CharacterSplit.newCharacterSplit(30))
                .byteField("teamSize", ByteSplit.newByteSplit(31, 33))
                .shortField("lunchTime", ShortSplit.newShortSplit(33, 36))
                .intField("businessCode", IntegerSplit.newIntegerSplit(36, 41))
                .longField("responsibleCode", LongSplit.newLongSplit(41, 49))
                .stringArrayField("keywords", StringArraySplitterBuilder
                        .newSplitter()
                        .addStringSplit(49, 59, WordCase.LOWER_CASE, true)
                        .addStringSplit(59, 69, WordCase.LOWER_CASE, true)
                        .addStringSplit(69, 79, WordCase.LOWER_CASE, true)
                        .addStringSplit(79, 89, WordCase.LOWER_CASE, true)
                        .addStringSplit(89, 96, WordCase.LOWER_CASE, true)
                        .build())
                .entityField(null, null )
                .buildEntity(DATA);

        Project expected = createTestProject();

        assertAll(
                () -> assertTrue(actual instanceof Project),
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getName(), actual.getName()),
                () -> assertEquals(expected.isActive(), actual.isActive()),
                () -> assertEquals(expected.getSymbol(), actual.getSymbol()),
                () -> assertEquals(expected.getTeamSize(), actual.getTeamSize()),
                () -> assertEquals(expected.getLunchTime(), actual.getLunchTime()),
                () -> assertEquals(expected.getBusinessCode(), actual.getBusinessCode()),
                () -> assertEquals(expected.getResponsibleCode(), actual.getResponsibleCode()),
                () -> assertEquals(expected.getKeywords(), actual.getKeywords())
        );
    }

    private Project createTestProject() {
        Project project = new Project();

        project.setId(1);
        project.setName("string splitter");
        project.setActive(true);
        project.setSymbol('æ');
        project.setTeamSize((byte)4);
        project.setLunchTime((short)90);
        project.setBusinessCode(11001);
        project.setResponsibleCode(88201101);

        List<String> keywords = new ArrayList<>();

        keywords.add("java");
        keywords.add("splitters");
        keywords.add("primitives");
        keywords.add("objects");
        keywords.add("maven");

        project.setKeywords(keywords);

        return project;
    }
}
