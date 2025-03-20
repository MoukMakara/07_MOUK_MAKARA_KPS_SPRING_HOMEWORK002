package org.ksga._07_mouk_makara_spring_homework002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
