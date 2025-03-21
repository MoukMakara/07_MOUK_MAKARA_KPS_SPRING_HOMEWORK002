package org.ksga._07_mouk_makara_spring_homework002.service;

import org.ksga._07_mouk_makara_spring_homework002.model.Course;
import org.ksga._07_mouk_makara_spring_homework002.model.Student;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.StudentCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    // Find all students with pagination
    List<Student> findAllStudents(Integer page, Integer size);

    // findStudentById
    Student findStudentById(Integer id);

    Student createStudent(StudentCreateRequest studentCreateRequest);

    // deleteStudentById
    void deleteStudentById(Integer id);

    // updateStudentById
    Student updateStudentById(Integer id, StudentUpdateRequest studentUpdateRequest);
}
