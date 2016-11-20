package com.exampe.money;

public class Pair {
    private String source;
    private String target;

    public Pair(String source, String target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public boolean equals(Object obj) {
        Pair other = (Pair) obj;
        return this.source == other.source && this.target == other.target;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
