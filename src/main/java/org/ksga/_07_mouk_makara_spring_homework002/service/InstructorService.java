package org.ksga._07_mouk_makara_spring_homework002.service;

import org.ksga._07_mouk_makara_spring_homework002.model.Instructor;
import org.ksga._07_mouk_makara_spring_homework002.model.request.InstructorCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.InstructorUpdateRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors(Integer page, Integer size);
    Instructor createInstructor(InstructorCreateRequest instructorCreateRequest);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    Instructor updateInstructorById(Integer id, InstructorUpdateRequest instructorUpdateRequest);
}
