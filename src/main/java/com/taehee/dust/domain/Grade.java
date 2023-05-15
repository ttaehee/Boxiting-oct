package com.taehee.dust.domain;

public enum Grade {
    GOOD(1, "좋음"),
    NORMAL(2, "보통"),
    BAD(3, "나쁨"),
    VERY_BAD(4, "매우 나쁨");

    private int grade;
    private String name;

    Grade(Integer grade, String name) {
        this.grade = grade;
        this.name = name;
    }
}
