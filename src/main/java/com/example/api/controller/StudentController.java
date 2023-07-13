package com.example.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Student;
import com.example.api.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("estudantes")
@AllArgsConstructor

public class StudentController {

    private StudentService estudanteService;

    /*Podemos usar esse @GetMapping para falar que sempre que tiver um estudante com um id passando por uma rota, estamos buscando esse id para leitura dos dados.*/
    @GetMapping("/{id}")
    public ResponseEntity<Student> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    };
    
    @GetMapping
    public List<Student> buscarTodosEstudantes() {
        return estudanteService.buscarTodosEstudantes();
    };
    
    @PostMapping
    public ResponseEntity<Student> cadastrarEstudante(@RequestBody Student estudante) {
       return estudanteService.cadastrarEstudante(estudante);
    };
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> atualizarEstudante(@PathVariable Long id, @RequestBody Student estudante) {
        return estudanteService.atualizarEstudante(estudante);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerEstudante(@PathVariable Long id) {
        return estudanteService.removerEstudante(id);
    };
}
