package org.ksga._07_mouk_makara_spring_homework002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorUpdateRequest {
    private String instructorName;
    private String email;
}
