package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.RatingCourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/avaliacoes")
public class RatingCourseController {
    
    private final RatingCourseService ratingCourseService;

    @PostMapping
    public ResponseEntity<String> rating(
            @RequestParam Long idStudent,
            @RequestParam String courseName,
            @RequestParam Integer ratingScore) {
       return ratingCourseService.rating(idStudent, courseName, ratingScore); 
    }
}
