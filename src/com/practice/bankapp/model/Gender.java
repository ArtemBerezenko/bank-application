package com.practice.bankapp.model;

public enum Gender {
    MALE("Mr"), FEMALE("Ms");

    private String prefix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    String getSalutation() {
        return prefix;
    }

    Gender(String prefix) {
        this.prefix = prefix;
    }

}
