package org.ksga._07_mouk_makara_spring_homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ksga._07_mouk_makara_spring_homework002.model.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest {
    private String courseName;
    private String description;
    private Integer instructor;
}
