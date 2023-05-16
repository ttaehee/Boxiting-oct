package com.taehee.dust.api.dto;

import lombok.Getter;

@Getter
public enum Grade {
    GOOD(1, "좋음"),
    NORMAL(2, "보통"),
    BAD(3, "나쁨"),
    VERY_BAD(4, "매우 나쁨"),
    NOT_EXISTS(5, "정보 없음");

    private int grade;
    private String name;

    Grade(Integer grade, String name) {
        this.grade = grade;
        this.name = name;
    }
}
