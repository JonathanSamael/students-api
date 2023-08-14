package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.api.entity.Student;

// @Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    //Native Query
    @Query(value = "SELECT e.* FROM api.student e" +
                   " left join api.rating_course ac ON ac.student_id = e.id " +
                   " WHERE ac.student_id is null", nativeQuery = true)
                   List<Student> findByAvaliacaoCursosEstudanteIsNullNativeQuery();

    // Opção a partir do JPQL
    @Query(value = "SELECT e FROM Student e" +
                   " join RatingCourse ac " +
                   "WHERE ac.student.id is null")
                   List<Student> findByAvaliacaoCursosEstudanteIsNullJPQL();

    //Esse código faz o mesmo que os anteriores resumidamente.
    List<Student> findByRatingCoursesStudentIsNull();
}
