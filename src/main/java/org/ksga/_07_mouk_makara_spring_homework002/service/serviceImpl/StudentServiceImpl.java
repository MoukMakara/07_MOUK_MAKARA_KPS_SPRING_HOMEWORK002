package org.ksga._07_mouk_makara_spring_homework002.service.serviceImpl;

import org.apache.ibatis.annotations.Param;
import org.ksga._07_mouk_makara_spring_homework002.model.Course;
import org.ksga._07_mouk_makara_spring_homework002.model.Student;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.StudentCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.StudentUpdateRequest;
import org.ksga._07_mouk_makara_spring_homework002.repository.CourseRepository;
import org.ksga._07_mouk_makara_spring_homework002.repository.StudentRepository;
import org.ksga._07_mouk_makara_spring_homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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
        Integer studentId = studentRepository.createStudent(studentCreateRequest);

        for (Integer courseId : studentCreateRequest.getCourses()) {  // 1 ,2 ,3
            studentRepository.createStudentCourse(studentId, courseId);
        }
        return studentRepository.findStudentById(studentId);

    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public Student updateStudentById(Integer id, StudentUpdateRequest studentUpdateRequest) {
        // find student id
        Student student = studentRepository.findStudentById(id);

        for (Integer courseId : studentUpdateRequest.getCourses() ){
            Course course = courseRepository.findCourseById(courseId);
            if (course == null) {
                return  null;
            }
        }
        // delete courses
        studentRepository.deleteStudentCourse(student.getStudentId());

        // update courses
        for (Integer courseId : studentUpdateRequest.getCourses()) {
            studentRepository.updateStudentCourse(student.getStudentId(), courseId);
        }
        // update new StudentName
        student.setStudentName(studentUpdateRequest.getStudentName());
        student.setEmail(studentUpdateRequest.getEmail());
        student.setPhoneNumber(studentUpdateRequest.getPhoneNumber());

        // update student
        studentRepository.updateStudentById(student.getStudentId(), studentUpdateRequest);

        return studentRepository.findStudentById(student.getStudentId());
    }

}
