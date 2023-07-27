package com.example.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Book;
import com.example.api.entity.Student;
import com.example.api.repository.BookRepository;
import com.example.api.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private BookRepository bookRepository;

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
        Set<Book> books = student.getBooks();
        student.setBooks(new HashSet<>());
        Student saveStudent = studentRepository.save(student);
        for (Book book : books) {
            book.setStudent(Student.builder().id(student.getId()).build());
            student.getBooks().add(bookRepository.save(book));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    };
    
    public ResponseEntity<Student> atualizarEstudante(Long id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            for (Book livros : student.getBooks()) {
                livros.setStudent(student);
            }
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
