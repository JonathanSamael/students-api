package com.example.api.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RatingCourseKey implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "student_id")
    Long studentId;
    
    @Column(name = "course_id")
    Long courseId;
}
