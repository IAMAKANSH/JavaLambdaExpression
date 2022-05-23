package com.java.funcprogramming;

import java.util.List;

public class Instructor {

    String name;
    int yearOfExperience;
    String title;
    String gender;
    boolean onlineCourses;
    List<String> courses;

    public Instructor(String name, int yearOfExperience, String title, String gender, boolean onlineCourses, List<String> courses) {
        this.name = name;
        this.yearOfExperience = yearOfExperience;
        this.title = title;
        this.gender = gender;
        this.onlineCourses = onlineCourses;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", yearOfExperience=" + yearOfExperience +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", onlineCourses=" + onlineCourses +
                ", courses=" + courses +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isOnlineCourses() {
        return onlineCourses;
    }

    public void setOnlineCourses(boolean onlineCourses) {
        this.onlineCourses = onlineCourses;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
