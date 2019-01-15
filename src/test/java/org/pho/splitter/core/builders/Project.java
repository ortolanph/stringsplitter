package org.pho.splitter.core.builders;

import java.util.List;

public class Project {

    private int id;

    private String name;

    private boolean active;

    private char symbol;

    private byte teamSize;

    private short lunchTime;

    private int businessCode;

    private long responsibleCode;

    private List<String> keywords;

    private Version version;

    public Project() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public byte getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(byte teamSize) {
        this.teamSize = teamSize;
    }

    public short getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(short lunchTime) {
        this.lunchTime = lunchTime;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(int businessCode) {
        this.businessCode = businessCode;
    }

    public long getResponsibleCode() {
        return responsibleCode;
    }

    public void setResponsibleCode(long responsibleCode) {
        this.responsibleCode = responsibleCode;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
