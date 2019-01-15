package org.pho.splitter.core.builders;

public class Version {

    private int major;

    private int minor;

    private int bugfix;

    public Version() {}

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getBugfix() {
        return bugfix;
    }

    public void setBugfix(int bugfix) {
        this.bugfix = bugfix;
    }
}
