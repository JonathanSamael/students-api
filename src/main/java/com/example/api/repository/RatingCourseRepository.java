package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.RatingCourse;
import com.example.api.entity.RatingCourseKey;

public interface RatingCourseRepository extends JpaRepository<RatingCourse, RatingCourseKey>{
    
}
