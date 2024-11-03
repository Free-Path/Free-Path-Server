package com.freepath.user.domain;

public enum Gender {

    MALE("남성"), FEMALE("여성"), UNKNOWN("알 수 없음");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Gender toGender(String gender) {
        return switch (gender.toLowerCase()) {
            case "male" -> MALE;
            case "female" -> FEMALE;
            default -> UNKNOWN;
        };
    }

}
