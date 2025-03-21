package org.ksga._07_mouk_makara_spring_homework002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<String> courses;
}
