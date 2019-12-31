package io.github.rishabh22;

public enum SortStrategy {
    BUBBLE("bubble"),
    SELECTION("selection"),
    INSERTION("insertion"),
    MERGE("merge"),
    QUICK("quick");

    String value;

    SortStrategy(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
