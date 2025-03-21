package org.ksga._07_mouk_makara_spring_homework002.controller;

import org.ksga._07_mouk_makara_spring_homework002.model.Course;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseCreateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.request.CourseUpdateRequest;
import org.ksga._07_mouk_makara_spring_homework002.model.response.ApiResponse;
import org.ksga._07_mouk_makara_spring_homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    // findAllCourses
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> findAllCourses(@RequestParam(defaultValue = "1") Integer page,
                                                                    @RequestParam(defaultValue = "10") Integer size){

        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .message("Find all courses is successfully")
                .payload(courseService.findAllCourses(page, size))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    // findCourseById
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> findCourseById(@PathVariable Integer id){
        Course course = courseService.findCourseById(id);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Find course by id is successfully")
                .payload(course)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
//    createCourse
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody CourseCreateRequest courseCreateRequest){
        Course newCourse = courseService.createCourse(courseCreateRequest);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Create new course is successfully")
                .payload(newCourse)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // deleteCourseById
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable Integer id){
        Course deletedCourse = courseService.findCourseById(id);
        if (deletedCourse == null){
            return ResponseEntity.notFound().build();
        }
        courseService.deleteCourseById(id);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Delete course by id is successfully")
                .payload(deletedCourse)
                .status(HttpStatus.NO_CONTENT)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
    // updateCourseById
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable Integer id, @RequestBody CourseUpdateRequest courseUpdateRequest){
        Course exitingCourse = courseService.findCourseById(id);

        if (exitingCourse == null){
            return ResponseEntity.notFound().build();
        }
        Course updatedCourse = courseService.updateCourseById(id, courseUpdateRequest);
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("Course updated successfully")
                .payload(updatedCourse)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
