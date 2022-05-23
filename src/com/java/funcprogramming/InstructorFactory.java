package com.java.funcprogramming;

import java.util.List;

public interface InstructorFactory {
    public abstract Instructor getInstructor(String name, int yearOfExperience, String title, String gender,
                                             Boolean onlineCourse, List<String> courses);
}
