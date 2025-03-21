package org.ksga._07_mouk_makara_spring_homework002.service.serviceImpl;

import org.ksga._07_mouk_makara_spring_homework002.model.Course;
import org.ksga._07_mouk_makara_spring_homework002.model.Student;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.StudentCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.repository.StudentRepository;
import org.ksga._07_mouk_makara_spring_homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents(Integer page, Integer size) {
        return studentRepository.findAllStudents(page, size);
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public Student createStudent(StudentCreateRequest studentCreateRequest) {
        return studentRepository.createStudent(studentCreateRequest);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteStudentById(id);
    }

}
