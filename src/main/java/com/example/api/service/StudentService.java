package com.example.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Student;
import com.example.api.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    //métodos criados para as interações do CRUD
    public ResponseEntity<Student> buscarEstudantePorId(Long id) {
        if (studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    };
    
    public Page<Student> buscarTodosEstudantes(PageRequest page) {
        return studentRepository.findAll(page);
    };
    
    public ResponseEntity<Student> cadastrarEstudante(Student student) {
        Student saveStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    };
    
    public ResponseEntity<Student> atualizarEstudante(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            Student saveStudent = studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    };

    public ResponseEntity<String> removerEstudante(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
    };
}
