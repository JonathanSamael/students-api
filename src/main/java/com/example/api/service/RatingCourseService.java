package com.example.api.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Course;
import com.example.api.entity.RatingCourse;
import com.example.api.entity.Student;
import com.example.api.repository.CourseRepository;
import com.example.api.repository.RatingCourseRepository;
import com.example.api.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatingCourseService {

    private final RatingCourseRepository ratingCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public ResponseEntity<String> rating(Long idStudent, String courseName, Integer ratingScore) {
        Optional<Student> studentOpt = studentRepository.findById(idStudent);
        if (!studentOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
        }

        Optional<Course> courseOpt = courseRepository.findByName(courseName);
        if (!courseOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }

        RatingCourse ratingCourse  = new RatingCourse();
        ratingCourse.setStudent(studentOpt.get());
        ratingCourse.setCourse(courseOpt.get());
        ratingCourse.setRatingScore(ratingScore);

        ratingCourseRepository.save(ratingCourse);
        return ResponseEntity.ok("Avaliação salva com sucesso.");
    }
    
}
