package org.pho.splitter.beans;

import java.time.LocalDate;

public class Project {

    //1STRING SPLITTER     JAVA8     POM       JAR       1.0.0
    private Integer id;
    private String name;
    private String language;
    private String type;
    private String packaging;
    private String version;
    private LocalDate openned;

    public Integer getId() {
        return id;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
        InstantiationException, NoSuchFieldException {
        Object o = Class.forName("org.pho.splitter.beans.Project").newInstance();

        System.out.println(Project.class.getName());

        o.getClass().getDeclaredField("id").set(o, new Integer(2));

        System.out.println(o.getClass().getDeclaredField("name").isSynthetic());
        System.out.println(((Project)o).getId());
    }
}
