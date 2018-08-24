# String Splitter

A String splitter util for Java. [![Build Status](https://travis-ci.org/ortolanph/stringsplitter.svg?branch=master)](https://travis-ci.org/ortolanph/stringsplitter) [![Coverage Status](https://coveralls.io/repos/github/ortolanph/stringsplitter/badge.svg?branch=master)](https://coveralls.io/github/ortolanph/stringsplitter?branch=master)

**DOCUMENTATION OUTDATED**

## Requirements

Java 8 or later.

## How to use

`StringSplitter` class:

```java

String DATA = "1STRING SPLITTER     JAVA8     POM       JAR       1.0.0   ";

StringSplitter splitter = new StringSplitter();

splitter.addSplit(Split.newSplit(0, 1));
splitter.addSplit(Split.newSplit(21, 31));
splitter.addSplit(Split.newSplit(1, 21));
splitter.addSplit(Split.newSplit(31, 41));
splitter.addSplit(Split.newSplit(41, 51));
splitter.addSplit(Split.newSplit(51));

List<String> result = splitter.stringSplit(DATA);

result.stream().foreach(System.out::println);

```

`StringSplitterBuilder` class:

```java

    StringSplitterBuilder
        .newSplitter()
        .addSplit(0, 1)
        .addSplit(1, 21)
        .addSplit(21, 31)
        .addSplit(31, 41)
        .addSplit(41, 51)
        .addSplit(51)
        .build()
        .stringSplit(DATA)
        .stream()
        .forEach(System.out::println);

```


https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
