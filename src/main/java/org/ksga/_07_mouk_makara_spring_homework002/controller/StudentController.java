package org.ksga._07_mouk_makara_spring_homework002.controller;

import org.ksga._07_mouk_makara_spring_homework002.model.Student;
import org.ksga._07_mouk_makara_spring_homework002.model.request.StudentCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.response.ApiResponse;
import org.ksga._07_mouk_makara_spring_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // Find all students with pagination
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> findAllStudents(@RequestParam(defaultValue = "1") Integer page,
                                                                      @RequestParam(defaultValue = "10") Integer size){
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("Find all students is successfully")
                .payload(studentService.findAllStudents(page, size))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // findStudentById
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> findStudentById(@PathVariable Integer id){
        Student student = studentService.findStudentById(id);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Find student by id is successfully")
                .payload(student)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    // createCourse
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        Student newStudent = studentService.createStudent(studentCreateRequest);
        System.out.println(newStudent);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Student is successfully created")
                .payload(newStudent)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // deleteStudentById
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable Integer id){
        Student existingStudent = studentService.findStudentById(id);

        if(existingStudent == null){
            return ResponseEntity.noContent().build();
        }
        studentService.deleteStudentById(id);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .message("Delete student is successfully deleted")
                .payload(existingStudent)
                .status(HttpStatus.NO_CONTENT)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
