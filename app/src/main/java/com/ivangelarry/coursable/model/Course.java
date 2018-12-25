package com.ivangelarry.coursable.model;

public class Course {

    private String code;
    private String title;
    private String instructor;

    public Course(String code, String title, String instructor) {
        this.code = code;
        this.title = title;
        this.instructor = instructor;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }
}
