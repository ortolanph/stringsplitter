# String Splitter

A String splitter util for Java.

|  Feature   | Status |
|:----------:|:------:|
| Unit Tests | [![Build Status](https://travis-ci.org/ortolanph/stringsplitter.svg?branch=master)](https://travis-ci.org/ortolanph/stringsplitter) |
| Coverage   | [![Coverage Status](https://coveralls.io/repos/github/ortolanph/stringsplitter/badge.svg?branch=master)](https://coveralls.io/github/ortolanph/stringsplitter?branch=master) |

## Requirements

Java 8 or later.

## Release Notes

### V4.1

 * Modifying the internal splitter mechanism
 * More unit testing added

### V4

 * Implemented Float splitter
 * Implemented Double splitter
 * Implemented exception flow tests on Date classes
 * Javadoc Documentation and other documentation fixed
 * Updated Javadoc documentation for packages
 * Updated this page with date examples

### V3

 * Organized packages into primitives, dates and string
 * Implemented LocalDate splitter
 * Implemented LocalTime splitter
 * Implemented LocalDateTime splitter
 * Implemented Date splitter
 * Implemented Calendar splitter
 * Javadoc Documentation and other documentation fixed
 * Updated Javadoc documentation for packages
 * Updated this page with date examples
 
## How to use

### Splitting Strings

```java
String data = "Collect THIS text";

// Only the text
String result = StringSplit
    .newStringSplit(7, 11)
    .split(data);

// Lower Case
String resultUpperCase = StringSplit
    .newStringSplit(7, 11, WordCase.LOWER_CASE)
    .split(data);

// Trimmed
String resultUpperCase = StringSplit
    .newStringSplit(7, 12, true)
    .split(data);

// Lower Case and Trimmed
String resultUpperCase = StringSplit
    .newStringSplit(7, 12, WordCase.LOWER_CASE, true)
    .split(data);
```

### Splitting String Arrays

```java
String data = "STRINGSPLITTER";

StringArraySplit StringArraySplit = new StringArraySplit();

StringArraySplit splitter = new StringArraySplit();

StringSplit stringSplit1 = StringSplit.newSplit(0, 6);
StringSplit stringSplit2 = StringSplit.newSplit(6);

splitter.addSplit(stringSplit1);
splitter.addSplit(stringSplit2);

List<String> result = splitter.split(data);
```

Or using a builder:

```java
String data = "STRINGSPLITTER";

List<String> result =
    StringArraySplitterBuilder
        .newSplitter()
        .addStringSplit(0, 6)
        .addStringSplit(6)
        .build()
        .split(data);
```


### Wrappers

#### Splitting Booleans

```java
String data = "FAILED SUCCESS";

Function conversionFunction<String, Boolean> = myTrue => {
    if(myTrue.equals("FAILED ") {
        return Boolean.FALSE;
    }

    if(myTrue.equals("SUCCESS") {
        return Boolean.TRUE;
    }

    return Boolean.FALSE;
};

BooleanSplit booleanSplit = BooleanSplit.newBooleanSplit(0, 7, conversionFunction);

boolean hasCompleted = booleanSplit.split(data);

```

#### Splitting Bytes

```java
String data = "textfile.txt  40KB";

ByteSplit byteSplit = ByteSplit.newByteSplit(12, 16);

byte fileSizeInKB = byteSplit.split(data);

```

#### Splitting Characters

```java
String data = "↑↑↓↓←→←→BA";

CharacterSplit characterSplit = CharacterSplit.newCharacterSplit(1);

char direction = characterSplit.split(data);
```

#### Splitting Shorts

```java
String data = "BANK BRAND25892";

ShortSplit shortSplit = ShortSplit.newShortSplit(10, 14);

short agencyNumber = shortSplit.split(data);
```

#### Splitting Integers

```java
String data = "FANCY LAPTOP i7     2,300";

IntegerSplit split = IntegerSplit.newIntegerSplit(20, ",");

int productPrice = split.split(data);
```

#### Splitting Longs

```java
String data = "EARTH     149600000"

LongSplit longSplit = LongSplit.newLongSplit(10);

long distanceFromTheSun = longSplit.split(data);

```

#### Splitting Floats

```java
String data = "2.67DATA"

FloatSplit floatSplit = FloatSplit.newFloatSplit(0, 4);

float price = floatSplit.split(data);
```

#### Splitting Doubles

```java
String data = "2.67DATA"

DoubleSplit doubleSplit = DoubleSplit.newDoubleSplit(0, 4);

double price = doubleSplit.split(data);
```

### Dates

#### Date

Without format:

```java
String data = "157374145700014/11/2019 14:24:17"

DateSplit dateSplit = DateSplit.fromLong(0, 13);

Date dateRecorded = dateSplit.split(data);

```
With format:

```java
String data = "157374145700014/11/2019 14:24:17"

SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

DateSplit dateSplit = DateSplit.fromFormatted(13, format);

Date dateRecorded = dateSplit.split(data);

```

#### Calendar

Without format:

```java
String data = "157374145700014/11/2019 14:24:17"

CalendarSplit dateSplit = CalendarSplit.fromLong(0, 13);

Date dateRecorded = dateSplit.split(data);

```
With format:

```java
String data = "157374145700014/11/2019 14:24:17"

SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

CalendarSplit dateSplit = CalendarSplit.fromFormatted(13, format);

Date dateRecorded = dateSplit.split(data);

```

#### LocalDate

Using the default format:

```java
String data = "14/12/19771977-12-14"

LocalDateSplit localDateSplit = LocalDateSplit.newLocalDateSplit(10);

LocalDate dateRecorded = localDateSplit.split(data);

```

Using a `DateTimeFormatter`:

```java
String data = "14/12/19771977-12-14"

DateTimeFormatter format = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral('/')
            .appendValue((ChronoField.MONTH_OF_YEAR), 2)
            .appendLiteral('/')
            .appendValue(ChronoField.YEAR, 2, 4, SignStyle.NEVER)
            .toFormatter();

LocalDateSplit localDateSplit = LocalDateSplit.fromFormatted(0, 10, format).split(data);

LocalDate dateRecorded = localDateSplit.split(data);

```

#### LocalTime

Using the default format:

```java
String data = "01:56:35 PM00:40:00.12"

LocalTimeSplit localTimeSplit = LocalTimeSplit.newLocalTimeSplit(11);

LocalTime timeRecorded = localTimeSplit.split(data);

```

Using a `DateTimeFormatter`:

```java
String data = "01:56:35 PM00:40:00.12"

DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss a");

LocalTimeSplit localTimeSplit = LocalTimeSplit.fromFormatted(0, 11, format);

LocalTime timeRecorded = localTimeSplit.split(data);

```

#### LocalDateTime

Using the default format:

```java
String data = "Thursday, 14 November 2019, 11:172019-11-14T11:17:39.049"

LocalDateTimeSplit localDateTimeSplit = LocalDateTimeSplit.newLocalDateTimeSplit(33);

LocalDateTime timestampRecorded = LocalDateTimeSplit.split(data);

```

Using a `DateTimeFormatter`:

```java
String data = "Thursday, 14 November 2019, 11:172019-11-14T11:17:39.049"

DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm");

LocalDateTimeSplit localDateTimeSplit = LocalDateTimeSplit.newLocalDateTimeSplit(0, 33, format);

LocalDateTime timestampRecorded = LocalDateTimeSplit.split(data);

```

## Next versions

The following table shows the plans to evolve the framework:

| Release | Feature | Status | Tasks Link |
|:-------:| ------- |:------:|:----------:|
| 1 | Framework architecture | Implemented | |
| 2 | StringSplit, StringArraySplit, CharacterSplit, ByteSplit, ShortSplit, IntegerSplit, LongSplit | Implemented | |
| 3 | LocalDateSplit, LocalTimeSplit, LocalDateTimeSplit, DateSplit and CalendarSplit | Implemented | [Tasks](V3Tasks.md) | 
| 4 | FloatSplit and DoubleSplit | Implemented | [Tasks](V4Tasks.md) |
| 4.1 | Refactorings, improvements, bugifxing and testing | Implemented | [Tasks](V41Tasks.md) |
| 5 | EntityBuilder, FieldSplit, Wiki pages (better documentation) and Issues fixing | [Tasks](V5Tasks.md) |

## Reference

[Java Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

[Java Reflection, but Faster](https://dzone.com/articles/java-reflection-but-faster?edition=399225&utm_source=Zone%20Newsletter&utm_medium=email&utm_campaign=java%202018-09-25)

[Setters, Method Handles, and Java 11
](https://dzone.com/articles/setters-method-handles-and-java-11)

[Guide to uploading artifacts to the Central Repository](https://maven.apache.org/repository/guide-central-repository-upload.html)

[How to Publish Your Artifacts to Maven Central](https://dzone.com/articles/publish-your-artifacts-to-maven-central)