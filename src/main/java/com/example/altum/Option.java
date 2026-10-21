package com.example.altum;

public class Option {

    private final String Key;
    private final String value;

    public Option(String key, String value) {
        Key = key;
        this.value = value;
    }

    public String getKey() {
        return Key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
