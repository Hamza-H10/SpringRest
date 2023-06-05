package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {
    //abstract method does not have a body
    public List<Course> getCourses();// this method is called from the controller, but we do not have body in methods in interface, so it executes the methods in child class or implementation class

    public Course getCourse(long courseId);// because runtime polymorphism occurs that is why (getCourse) in implementation class will be executed

    public Course addCourse(Course course);

    public Course updateCourse(Course course);
    public void deleteCourse(long parseLong);
}
