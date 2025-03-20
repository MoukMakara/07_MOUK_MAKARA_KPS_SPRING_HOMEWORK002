package org.ksga._07_mouk_makara_spring_homework002.service;

import org.ksga._07_mouk_makara_spring_homework002.model.Course;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseUpdateRequest;

import java.util.List;

public interface CourseService {
    // findAllCourses
    List<Course> findAllCourses(Integer page, Integer size);
    // findCourseById
    Course findCourseById(Integer id);
    Course createCourse(CourseCreateRequest courseCreateRequest);
    void deleteCourseById(Integer id);
    Course updateCourseById(Integer id, CourseUpdateRequest courseUpdateRequest);
}
