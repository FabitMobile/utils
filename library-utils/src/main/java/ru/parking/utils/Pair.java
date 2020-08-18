package ru.parking.utils;

public class Pair<F, S> {

    private final F first;
    private final S second;


    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    //region ===================== Getters ======================

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    //endregion

    @Override
    public int hashCode() {
        return first.hashCode() ^ second.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return this.first.equals(pair.getFirst()) &&
                this.second.equals(pair.getSecond());
    }
}