package ru.fabit.utils;

import java.util.NoSuchElementException;


public class Optional<T> {

    private final T value;


    public Optional(T value) {
        this.value = value;
    }

    public static <T> Optional<T> createEmpty() {
        return new Optional<>(null);
    }


    public boolean isNull() {
        return value == null;
    }

    public boolean isNotNull() {
        return !isNull();
    }

    public T getValue() {
        if (value == null) {
            throw new NoSuchElementException("No value present in this Optional");
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Optional<?> optional = (Optional<?>) o;

        return value != null ? value.equals(optional.value) : optional.value == null;
    }
}
